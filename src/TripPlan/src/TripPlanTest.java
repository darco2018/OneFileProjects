
public class TripPlanTest {

	public static void main(String[] args) {

			TripPlan plan = new TripPlan();
			plan.addCity("NY");
			plan.addCity("Chicago");
			plan.addCity("Nairobi");
			plan.addCity("Wieliczka");
			plan.addCity("Krak�w");
			
			plan.reverse();
			System.out.println(plan);
			
			plan.removeCity("Chicago");
			System.out.println(plan);
	}

}
