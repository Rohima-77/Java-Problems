Develop an email address validator using the concept of Exception Handling in java considering the
following constrains: 1.Each of the letters should be small letters. 2.Can't start with a number or digit
character. 3.Can't start with a s[pecial character. 4.Can Contain only these special character ['_', '.'
and '&'] in the hostname part. 5.Allowed Company Domains ["gmail","yahoo","outlook","icloud" &
"hotmail"] 6.Allowed Institutional Domains ["edu" , "ag" , "mil" & "org"]. 7.Allowed Country Domains
["bd" , "in" , "pk" , "us" & "uk"].
NB: Email = [hostname]@[companyDomain].[institutionalDomain].[countryDomain]

  
import java.util.Scanner;
class InvalidEmailException extends Exception {
public InvalidEmailException(String message) {
super(message);
}
}
public class EmailValidator {
// Allowed domain parts
static String[] allowedCompanies = {"gmail", "yahoo", "outlook", "icloud", "hotmail"};
static String[] allowedInstitutions = {"edu", "ag", "mil", "org"};
static String[] allowedCountries = {"bd", "in", "pk", "us", "uk"};
// Check if value is in array
public static boolean isValid(String value, String[] list) {
for (String s : list) {
if (s.equals(value)) return true;
}
return false;
}
public static void validateEmail(String email) throws InvalidEmailException {
// 1. Check all letters are lowercase
if (!email.equals(email.toLowerCase())) {
throw new InvalidEmailException("Email must be in lowercase.");
}
// 2. Check for one '@' only
String[] emailParts = email.split("@");
if (emailParts.length != 2) {
throw new InvalidEmailException("Email must contain exactly one '@' symbol.");
}
String hostname = emailParts[0];
String domainPart = emailParts[1];
// 3. Check hostname is not empty
if (hostname.isEmpty()) {
throw new InvalidEmailException("Hostname cannot be empty.");
}
// 4. Hostname must not start with digit or special char
char firstChar = hostname.charAt(0);
if (!Character.isLetter(firstChar)) {
throw new InvalidEmailException("Hostname must start with a letter.");
}
// 5. Check hostname characters
for (char ch : hostname.toCharArray()) {
if (!Character.isLetterOrDigit(ch) && ch != '_' && ch != '.' && ch != '&') {
throw new InvalidEmailException("Hostname contains invalid special characters.");
}
}
// 6. Check domain parts
String[] domainParts = domainPart.split("\\.");
if (domainParts.length != 3) {
throw new InvalidEmailException("Domain format must be: company.institution.country");
}
String company = domainParts[0];
String institution = domainParts[1];
String country = domainParts[2];
if (!isValid(company, allowedCompanies)) {
throw new InvalidEmailException("Invalid company domain: " + company);
}
if (!isValid(institution, allowedInstitutions)) {
throw new InvalidEmailException("Invalid institutional domain: " + institution);
}
if (!isValid(country, allowedCountries)) {
throw new InvalidEmailException("Invalid country domain: " + country);
}
System.out.println(" Valid Email Address!");
}
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter email to validate: ");
String email = scanner.nextLine();
try {
validateEmail(email);
} catch (InvalidEmailException e) {
System.out.println(" Invalid Email: " + e.getMessage());
}
}
}
