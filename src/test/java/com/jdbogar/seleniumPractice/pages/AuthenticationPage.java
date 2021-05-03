package com.jdbogar.seleniumPractice.pages;

import org.openqa.selenium.support.FindBy;
import com.jdbogar.seleniumPractice.annotations.PageInstance;
import com.jdbogar.seleniumPractice.annotations.PageObject;
import com.jdbogar.seleniumPractice.elements.base.Element;
import com.jdbogar.seleniumPractice.elements.factory.widget.Select;
import com.jdbogar.seleniumPractice.elements.factory.widget.TextInput;

@PageObject
public class AuthenticationPage extends BasePage {
	
	@PageInstance
	private CreateAnAccount createAnAccount;
	
	@PageInstance
	private AlreadyRegistered alreadyRegistered;
	
	@PageObject
	public class AlreadyRegistered extends BasePage {
		@FindBy(id="email")
		private TextInput emailAddress;
		
		@FindBy(id="passwd")
		private TextInput password;
		
		@FindBy(id="SubmitLogin")
		private Element signInButton;

		public final TextInput emailAddress() {
			return emailAddress;
		}

		public final TextInput password() {
			return password;
		}
		
		public final Element signInButton() {
			return signInButton;
		}
	}
	
	@PageObject
	public class CreateAnAccount extends BasePage {
		
		@FindBy(id="email_create")
		private TextInput emailAddress;
		
		@FindBy(css="button[id='SubmitCreate'] span")
		private Element createAccountButton;
		
		@FindBy(id="id_gender1")
		private Element mrRadioButton;
		
		@FindBy(id="id_gender2")
		private Element mrsRadioButton;
		
		@FindBy(id="customer_firstname")
		private TextInput yourPersonalInfoFirstName;
		
		@FindBy(id="customer_lastname")
		private TextInput yourPersonalInfoLastName;
		
		@FindBy(id="passwd")
		private TextInput password;
		
		@FindBy(id="days")
		private Select day;
		
		@FindBy(id="months")
		private Select month;
		
		@FindBy(id="years")
		private Select year;
		
		@FindBy(id="firstname")
		private TextInput yourAddressFirstName;
		
		@FindBy(id="lastname")
		private TextInput yourAddressLastName;
		
		@FindBy(id="company")
		private TextInput company;
		
		@FindBy(id="address1")
		private TextInput addressLine1;
		
		@FindBy(id="address2")
		private TextInput addressLine2;
		
		@FindBy(id="city")
		private TextInput city;
		
		@FindBy(id="id_state")
		private Select state;
		
		@FindBy(id="postcode")
		private TextInput zipCode;
		
		@FindBy(id="id_country")
		private Select country;
		
		@FindBy(id="other")
		private TextInput additionalInfo;
		
		@FindBy(id="phone")
		private TextInput homePhone;
		
		@FindBy(id="phone_mobile")
		private TextInput mobilePhone;
		
		@FindBy(id="alias")
		private TextInput addressAlias;
		
		@FindBy(css="button[id='submitAccount'] span")
		private Element registerButton;

		public final Element registerButton() {
			return registerButton;
		}

		public final TextInput emailAddress() {
			return emailAddress;
		}

		public final Element createAccountButton() {
			return createAccountButton;
		}

		public final Element mrRadioButton() {
			return mrRadioButton;
		}

		public final Element mrsRadioButton() {
			return mrsRadioButton;
		}

		public final TextInput yourPersonalInfoFirstName() {
			return yourPersonalInfoFirstName;
		}

		public final TextInput yourPersonalInfoLastName() {
			return yourPersonalInfoLastName;
		}

		public final TextInput password() {
			return password;
		}

		public final Select day() {
			return day;
		}

		public final Select month() {
			return month;
		}

		public final Select year() {
			return year;
		}

		public final TextInput yourAddressFirstName() {
			return yourAddressFirstName;
		}

		public final TextInput yourAddressLastName() {
			return yourAddressLastName;
		}

		public final TextInput company() {
			return company;
		}

		public final TextInput addressLine1() {
			return addressLine1;
		}

		public final TextInput addressLine2() {
			return addressLine2;
		}

		public final TextInput city() {
			return city;
		}

		public final Select state() {
			return state;
		}

		public final TextInput zipCode() {
			return zipCode;
		}

		public final Select country() {
			return country;
		}

		public final TextInput additionalInfo() {
			return additionalInfo;
		}

		public final TextInput homePhone() {
			return homePhone;
		}

		public final TextInput mobilePhone() {
			return mobilePhone;
		}

		public final TextInput addressAlias() {
			return addressAlias;
		}
	}
	
	public CreateAnAccount createAnAccount() {
		return createAnAccount;
	}
	
	public AlreadyRegistered alreadyRegistered() {
		return alreadyRegistered;
	}


}
