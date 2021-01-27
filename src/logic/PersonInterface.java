package logic;

public interface PersonInterface {
	public void create(Person person);
	public void update(Person person);
	public void delete(Person person);
	public void find(String fname, String lname, String mobile, String email, String interest);
}
