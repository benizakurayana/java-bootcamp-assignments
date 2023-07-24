package homework.rolegame_improve;

public abstract class Hero {
	// 省略 getter/setter...
	
	protected String name;
	protected int level;
	protected double exp;
	
	protected IEquipment weapon;
	protected IEquipment armor;
	protected IEquipment shoes;
	protected IEquipment[] inventory = new IEquipment[15];
	
	protected ISpell[] spells = new ISpell[4];

	
	public Hero() {
		
	}
	
	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}
	
	public void equip(IEquipment item) {
		System.out.println("裝備XXX");
	
		if (item instanceof Weapon) {

			if (weapon != null) {

			}
			weapon = item;
		} else if (item instanceof Armor) {
			if (armor != null) {
				intoInventory(armor);
			}
			armor = item;
		} else {
			if (shoes != null) {
				intoInventory(shoes);
			}
			shoes = item;
		}
	}
	
	private void intoInventory(IEquipment item) {
		for (int i = 0; i < inventory.length; i++) {
				if (inventory[i] == null) {
					inventory[i] = item;
				}
			}
		System.out.println("原本裝備中的YYY已放到倉庫");
	}
	
	public void learnSpellQ(ISpell spell) {
		if (spells[0] == null) {
			spells[0] = spell;
			System.out.println("學到Q技能");
		} else {
			System.out.println("Q技能已學過");
		}
	}
	
	public void castSpellQ() {
		if (spells[0] == null) {
			System.out.println("尚未學習Q技能");
		} else {
			spells[0].cast();
		}
	}
}
