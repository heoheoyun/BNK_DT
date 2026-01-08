package d0107;

public class Unit {
	
	private String name;
	private int energy;
	private boolean is_Alive = true;
	
	Unit(String name) {
		setName(name);
		energy = 5;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getEnergy() {
		return energy;
	}
	
	Boolean getIsAlive() {
		return is_Alive;
	}
	
	String unitInfo() {
		String alive;
		if (getIsAlive()) alive = "동작중";
		else alive = "동작 중지";
		
		return "기체명 : " + getName() + ", 남은 동력 : " + getEnergy() + "("+alive+")";
	}
	
	void attack(Unit unit) {
		if(unit.getEnergy()==0) {
			System.out.println(getName()+"가 공격하려던 "+ unit.getName()+"은 파괴된 유닛입니다.");
			return;
		}
		if(getEnergy()==0) {
			System.out.println("동작이 정지되어 공격이 불가능합니다.");
			return;
		}
		
		System.out.println(getName()+"가 "+unit.getName()+"에게 공격했습니다.");
		unit.attacked();
	}
	
	void attacked() {
		if(getEnergy()-2<=0) {
			energy = 0;
			System.out.println(getName()+"기체의 동작이 정지됩니다.");
		} else energy -=2;
	}
	
}
