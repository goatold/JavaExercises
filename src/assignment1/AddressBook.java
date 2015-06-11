/**
 * 
 */
package assignment1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author goat
 *
 */
public class AddressBook {

	private String firstName;
	private String middleName;
	private String lastName;
	private String homeAddress;
	private String businessPhone;
	private String homePhone;
	private String cellphone;
	private String skypeId;
	private String facebookId;
	private String personalWebSite;

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param homeAddress
	 * @param businessPhone
	 * @param homePhone
	 * @param cellphone
	 * @param skypeId
	 * @param facebookId
	 * @param personalWebSite
	 */
	public AddressBook(String firstName, String middleName, String lastName,
			String homeAddress, String businessPhone, String homePhone,
			String cellphone, String skypeId, String facebookId,
			String personalWebSite) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.homeAddress = homeAddress;
		this.businessPhone = businessPhone;
		this.homePhone = homePhone;
		this.cellphone = cellphone;
		this.skypeId = skypeId;
		this.facebookId = facebookId;
		this.personalWebSite = personalWebSite;
	}

	/**
	 * @param firstName
	 */
	public AddressBook(String firstName) {
		super();
		this.firstName = firstName;
	}

	
	/**
	 * @param firstName
	 * @param middleName
	 */
	public AddressBook(String firstName, String middleName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
	}

		
	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public AddressBook(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * @param numStr a string represent a phone number to be validated
	 * return boolean
	 */
	public static boolean validPhoneNum(String numStr) {
		Pattern pattern = Pattern.compile("+?\\d+[\\d\\- ]*\\d");
		Matcher matcher = pattern.matcher(numStr);
		return matcher.matches();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test this class
		

	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the businessPhone
	 */
	public String getBusinessPhone() {
		return businessPhone;
	}
	/**
	 * @param businessPhone the businessPhone to set
	 */
	public void setBusinessPhone(String businessPhone) {
		if(!AddressBook.validPhoneNum(businessPhone)) {
			System.out.printf("invalid phone number:%s\n", businessPhone);
			return;
		}
		this.businessPhone = businessPhone;
	}
	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}
	/**
	 * @param cellphone the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	/**
	 * @return the skypeId
	 */
	public String getSkypeId() {
		return skypeId;
	}
	/**
	 * @param skypeId the skypeId to set
	 */
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	/**
	 * @return the facebookId
	 */
	public String getFacebookId() {
		return facebookId;
	}
	/**
	 * @param facebookId the facebookId to set
	 */
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	/**
	 * @return the personalWebSite
	 */
	public String getPersonalWebSite() {
		return personalWebSite;
	}
	/**
	 * @param personalWebSite the personalWebSite to set
	 */
	public void setPersonalWebSite(String personalWebSite) {
		this.personalWebSite = personalWebSite;
	}

}
