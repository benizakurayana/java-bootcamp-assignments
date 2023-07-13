//請運用多型設計讓Powder, Plane, Dog這三個類別藉由getWeightTool()方法可以顯示出各自適合的量體重的工具
//(如: Powder使用天秤, Plane使用地磅, Dog使用體重計)
//
//模仿TestPolymorphism2.java的格式寫測試用的class: TestWeigh.java

package xxx;

public class TestWeigh {
	public static void main(String[] args) {
		Weighable[] e = new Weighable[3]; 
		e[0] = new Dog();
		e[1] = new Plane();
		e[2] = new Powder();
		for (int i = 0; i < e.length; i++)
			e[i].getWeightTool();
	}
}
