package homework.rolegame_improve;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("李逍遙", 1, 0.0);
		
		
		saber.learnSpellQ(new SpellDionysian());
		saber.learnSpellQ(new SpellDionysian());
		saber.castSpellQ();
		saber.equip(new Sword(), 0);
		
	}

}
