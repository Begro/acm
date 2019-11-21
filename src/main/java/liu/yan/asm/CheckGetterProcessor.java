package liu.yan.asm;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic.Kind;
import java.util.Set;

@SupportedAnnotationTypes("liu.yan.asm.CheckGetter")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CheckGetterProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    // TODO: annotated ElementKind.FIELD
    for (TypeElement annotatedClass : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(CheckGetter.class))) {
      for (VariableElement field : ElementFilter.fieldsIn(annotatedClass.getEnclosedElements())) {
        if (!containsGetter(annotatedClass, field.getSimpleName().toString())) {
          processingEnv.getMessager().printMessage(Kind.ERROR,
              String.format("getter not found for '%s.%s'.", annotatedClass.getSimpleName(), field.getSimpleName()));
        }
      }
    }
    return true;
  }

  private static boolean containsGetter(TypeElement typeElement, String name) {
    String getter = "get" + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    for (ExecutableElement executableElement : ElementFilter.methodsIn(typeElement.getEnclosedElements())) {
      if (!executableElement.getModifiers().contains(Modifier.STATIC)
          && executableElement.getSimpleName().toString().equals(getter)
          && executableElement.getParameters().isEmpty()) {
        return true;
      }
    }
    return false;
  }
}
