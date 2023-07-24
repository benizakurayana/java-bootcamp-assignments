package homework.rolegame_improve;

public class SpellDionysian implements ISpell {
	int remainingUses = 9;

	public void cast() {
		if (remainingUses > 0) {
			remainingUses -= 1;
			System.out.printf("施放酒神咒。剩餘次數：%d\n", remainingUses);
		} else {
			System.out.println("九次的酒神咒已使用完畢，無法再次施放");
		}

	}

}
