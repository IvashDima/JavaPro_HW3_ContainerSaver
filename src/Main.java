import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//2. Написать класс TextContainer, который содержит в себе строку.
// С помощью механизма аннотаций указать
// 1) в какой файл должен сохраниться текст
// 2) метод, который выполнит сохранение. Написать класс Saver,
// который сохранит поле класса TextContainer в указанный файл.
//@SaveTo(path=“c:\\file.txt”)
//class Container {
//    String text = “…”;
//    @Saver
//    public void save(..) {…}
//}
class Container{
    String text="Hi my friends!";
}
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Container c1 = new Container();
        SaverUtils s1 = new SaverUtils();
        for(Method method: s1.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(SaveTo.class)){
                SaveTo annotation = method.getAnnotation(SaveTo.class);
                method.invoke(s1,c1, annotation.path());
            }
        }
    }
}