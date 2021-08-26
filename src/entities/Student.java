package entities;

public class Student {
	
	private int id;
	private String lastName;
	private String firstName;
	private String mail;
	private String githubURL;
	private String pathPhoto;
	
	/**
	 * Creates a new student.
	 * @param id The new student's university id.
	 * @param lastName The new student's last name.
	 * @param firstName The new student's first name.
	 * @param mail The new student's e-mail.
	 * @param githubURL The new student's GitHub profile URL.
	 * @param pathPhoto The new student's photo path.
	 */
	public Student(int id, String lastName, String firstName, String mail, String githubURL, String pathPhoto) {
		this.id =id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.mail = mail;
		this.githubURL = githubURL;
		this.pathPhoto = pathPhoto;
	}
	
	/**
	 * Returns the student's id.
	 * @return The student's id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the student's last name.
	 * @return The student's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns the student's first name.
	 * @return The student's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the student's e-mail.
	 * @return The student's e-mail.
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Returns the student's GitHub profile URL.
	 * @return The student's GitHub profile URL.
	 */
	public String getGithubURL() {
		return githubURL;
	}
	
	/**
	 * Returns the student's photo path.
	 * @return The student's photo path.
	 */
	public String getPathPhoto() {
		return pathPhoto;
	}
	
	/**
	 * Sets the student's id.
	 * @param id The new id for this student.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the student's last name.
	 * @param lastName The new last name for this student.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Sets the student's first name.
	 * @param firstName The new first name for this student.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Sets the student's mail.
	 * @param mail The new e-mail for this student.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Sets the student's GitHub profile URL.
	 * @param githubURL The new GitHub profile URL for this student.
	 */
	public void setGithubURL(String githubURL) {
		this.githubURL = githubURL;
	}
	
	/**
	 * Sets the student's photo path.
	 * @param pathPhoto The new path to this student's photo.
	 */
	public void setPathPhoto(String pathPhoto) {
		this.pathPhoto = pathPhoto;
	}
}