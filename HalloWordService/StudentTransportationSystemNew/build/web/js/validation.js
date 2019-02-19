/**
 * SHARAAN SHAS...3(9538180903)
 */

/** Login Form Validation done */
function docFormValidate() {
	var key = document.forms.loginForm.key.value;

	if (key == null || key == "") {
		alert("key Should not be null or empty ");
		document.forms.loginForm.key.focus();
		return false;
	}
}

/** BG Access Form Validation done */

function bgAccessFormValidate() {
	var kgcKey = document.forms.loginForm.kgcKey.value;

	if (kgcKey == null || kgcKey == "") {
		alert("kGC Key Should not be null or empty ");
		document.forms.loginForm.kgcKey.focus();
		return false;
	}

	var paKey = document.forms.loginForm.paKey.value;

	if (paKey == null || paKey == "") {
		alert("PA Key Should not be null or empty ");
		document.forms.loginForm.paKey.focus();
		return false;
	}
}

function LoginFormValidate() {
	var username = document.forms.loginForm.nme.value;
	var password = document.forms.loginForm.pwd.value;

	if (username == null || username == "") {
		alert("Username Should not be null or empty ");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (/\s/g.test(username)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (password == null || password == "") {
		alert("Password Should not be null or empty ");
		document.forms.loginForm.pwd.focus();
		return false;
	}

	if (password.length < 3) {
		alert("Minimum Lenght Should be 3");
		document.forms.loginForm.pwd.focus();
		return false;
	}

	if (/\s/g.test(password)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.pwd.focus();
		return false;
	}
}

/** Common Login Form Validation done */
function commonLoginFormValidate() {
	var user = document.forms.loginForm.user.value;
	var username = document.forms.loginForm.nme.value;
	var password = document.forms.loginForm.pwd.value;

	if (user == "--Select--") {
		alert("User Should not be null or empty ");
		document.forms.loginForm.user.focus();
		return false;
	}

	if (username == null || username == "") {
		alert("Username Should not be null or empty ");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (/\s/g.test(username)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.nme.focus();
		return false;
	}

	if (password == null || password == "") {
		alert("Password Should not be null or empty ");
		document.forms.loginForm.pwd.focus();
		return false;
	}

	if (password.length < 3) {
		alert("Minimum Lenght Should be 3");
		document.forms.loginForm.pwd.focus();
		return false;
	}

	if (/\s/g.test(password)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.loginForm.pwd.focus();
		return false;
	}
}

/** Add Doctor Form Validation */
function addDoctorValidate() {

	var dr_name = document.forms.addDoctor.dr_name.value;

	var name = /^\S/;

	if (dr_name == null || dr_name == "") {
		alert("dr.name Should not be null or empty ");
		document.forms.addDoctor.dr_name.focus();
		return false;
	}

	if (!name.test(dr_name)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addDoctor.dr_name.focus();
		return false;
	}

	if (isNaN(dr_name) == false) {
		alert("Please give Characters in dr_name Field");
		document.forms.addDoctor.dr_name.focus();
		return false;
	}

	if (dr_name.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.addDoctor.dr_name.focus();
		return false;
	}

	var specialist = document.forms.addDoctor.specialist.value;

	if (specialist == null || specialist == "") {
		alert("Specialist Should not be null or empty ");
		document.forms.addDoctor.specialist.focus();
		return false;
	}

	if (!name.test(specialist)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addDoctor.specialist.focus();
		return false;
	}

	if (isNaN(specialist) == false) {
		alert("Please give Characters in Specialist Field");
		document.forms.addDoctor.specialist.focus();
		return false;
	}

	if (specialist.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.addDoctor.specialist.focus();
		return false;
	}

	var qualification = document.forms.addDoctor.qualification.value;

	if (qualification == null || qualification == "") {
		alert("Qualification Should not be null or empty ");
		document.forms.addDoctor.qualification.focus();
		return false;
	}

	if (!name.test(qualification)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addDoctor.qualification.focus();
		return false;
	}

	if (isNaN(qualification) == false) {
		alert("Please give Characters in Qualification Field");
		document.forms.addDoctor.qualification.focus();
		return false;
	}

	var experience = document.forms.addDoctor.experience.value;

	if (isNaN(experience)) {
		alert("Please enter numeric value for Experience");
		document.forms.addDoctor.experience.focus();
		return false;
	}
	var phn = /^\S*$/;

	if (!phn.test(experience)) {
		alert("White spaces are not allowed in Experience");
		document.forms.addDoctor.experience.focus();
		return false;
	}

	var date = document.forms.addDoctor.dob.value;

	if (date == null || date == "") {
		alert("Date Should not be null or empty ");
		document.forms.addDoctor.dob.focus();
		return false;
	}

	var email = document.forms.addDoctor.emailId.value;
	var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	if (email == null || email == "") {
		alert("Email_Id Should not be null or empty ");
		document.forms.addDoctor.emailId.focus();
		return false;
	}

	if (!name.test(email)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addDoctor.emailId.focus();
		return false;
	}

	if (!mail.test(email)) {
		alert("Please give valid email Id");
		document.forms.addDoctor.emailId.focus();
		return false;
	}

	var phone = document.forms.addDoctor.mobileNumber.value;

	if (isNaN(phone)) {
		alert("Please enter numeric value for Mobile Number");
		document.forms.addDoctor.mobileNumber.focus();
		return false;
	}
	var phn = /^\S*$/;

	if (!phn.test(phone)) {
		alert("White spaces are not allowed in Mobile Number");
		document.forms.addDoctor.mobileNumber.focus();
		return false;
	}

	if (phone.length > 10 || phone.length < 10) {
		alert("Mobile number length should be 10");
		document.forms.addDoctor.mobileNumber.focus();
		return false;
	}

	var file = document.forms.addDoctor.file.value;

	if (file == "") {
		alert("Image File Should not be null or empty,Please select the file");
		document.forms.addDoctor.file.focus();
		return false;
	}
}

/** Add Patient Form Validation */
function addPatientValidate() {

	var patientname = document.forms.addPatient.patientname.value;

	var name = /^\S/;

	if (patientname == null || patientname == "") {
		alert("Patient name Should not be null or empty ");
		document.forms.addPatient.patientname.focus();
		return false;
	}

	if (isNaN(patientname) == false) {
		alert("Please give Characters in Patient name Field");
		document.forms.addPatient.patientname.focus();
		return false;
	}

	if (patientname.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.addPatient.patientname.focus();
		return false;
	}

	var type = document.forms.addPatient.type.value;

	if (type == null || type == "") {
		alert("type Should not be null or empty ");
		document.forms.addPatient.type.focus();
		return false;
	}

	if (!name.test(type)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addPatient.type.focus();
		return false;
	}

	if (isNaN(type) == false) {
		alert("Please give Characters in type Field");
		document.forms.addPatient.type.focus();
		return false;
	}

	if (type.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.addPatient.type.focus();
		return false;
	}

	var patientFile = document.forms.addPatient.patientFile.value;

	if (patientFile == "") {
		alert("Patient File Should not be null or empty,Please select the file");
		document.forms.addPatient.patientFile.focus();
		return false;
	}

	var address = document.forms.addPatient.address.value;

	if (address == null || address == "") {
		alert("description Should not be null or empty ");
		document.forms.addPatient.address.focus();
		return false;
	}

	var date = document.forms.addPatient.dob.value;

	if (date == null || date == "") {
		alert("Date Should not be null or empty ");
		document.forms.addPatient.dob.focus();
		return false;
	}

	var email = document.forms.addPatient.emailId.value;
	var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	if (email == null || email == "") {
		alert("Email_Id Should not be null or empty ");
		document.forms.addPatient.emailId.focus();
		return false;
	}

	if (!name.test(email)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addPatient.emailId.focus();
		return false;
	}

	if (!mail.test(email)) {
		alert("Please give valid email Id");
		document.forms.addPatient.emailId.focus();
		return false;
	}

	var phone = document.forms.addPatient.mobileNumber.value;

	if (isNaN(phone)) {
		alert("Please enter numeric value for Mobile Number");
		document.forms.addPatient.mobileNumber.focus();
		return false;
	}
	var phn = /^\S*$/;

	if (!phn.test(phone)) {
		alert("White spaces are not allowed in Mobile Number");
		document.forms.addPatient.mobileNumber.focus();
		return false;
	}

	if (phone.length > 10 || phone.length < 10) {
		alert("Mobile number length should be 10");
		document.forms.addPatient.mobileNumber.focus();
		return false;
	}

	var file = document.forms.addPatient.file.value;

	if (file == "") {
		alert("Image File Should not be null or empty,Please select the file");
		document.forms.addPatient.file.focus();
		return false;
	}
}

/** Add ECP Form Validation */
function ecpValidate() {

	var name = document.forms.addECP.name.value;

	if (name == null || name == "") {
		alert("Name Should not be null or empty ");
		document.forms.addECP.name.focus();
		return false;
	}

	if (isNaN(name) == false) {
		alert("Please give Characters in Name Field");
		document.forms.addECP.name.focus();
		return false;
	}

	if (name.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.addECP.name.focus();
		return false;
	}

	var address = document.forms.addECP.address.value;

	if (address == null || address == "") {
		alert("description Should not be null or empty ");
		document.forms.addECP.address.focus();
		return false;
	}

	var email = document.forms.addECP.emailId.value;
	var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	if (email == null || email == "") {
		alert("Email_Id Should not be null or empty ");
		document.forms.addECP.emailId.focus();
		return false;
	}

	if (!name.test(email)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.addECP.emailId.focus();
		return false;
	}

	if (!mail.test(email)) {
		alert("Please give valid email Id");
		document.forms.addECP.emailId.focus();
		return false;
	}

	var phone = document.forms.addECP.mobileNumber.value;

	if (isNaN(phone)) {
		alert("Please enter numeric value for Mobile Number");
		document.forms.addECP.mobileNumber.focus();
		return false;
	}
	var phn = /^\S*$/;

	if (!phn.test(phone)) {
		alert("White spaces are not allowed in Mobile Number");
		document.forms.addECP.mobileNumber.focus();
		return false;
	}

	if (phone.length > 10 || phone.length < 10) {
		alert("Mobile number length should be 10");
		document.forms.addECP.mobileNumber.focus();
		return false;
	}

	var file = document.forms.addECP.file.value;

	if (file == "") {
		alert("Image File Should not be null or empty,Please select the file");
		document.forms.addECP.file.focus();
		return false;
	}
}

function regFormValidate() {

	var fname = document.forms.regForm.First_Name.value;

	var name = /^\S/;

	if (fname == null || fname == "") {
		alert("First_Name Should not be null or empty ");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (!name.test(fname)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (isNaN(fname) == false) {
		alert("Please give Characters in First_Name Field");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	if (fname.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.First_Name.focus();
		return false;
	}

	var lname = document.forms.regForm.Last_Name.value;

	if (lname == null || lname == "") {
		alert("Last_Name Should not be null or empty ");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (!name.test(lname)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (isNaN(lname) == false) {
		alert("Please give Characters in Last_Name Field");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	if (lname.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.Last_Name.focus();
		return false;
	}

	var date = document.forms.regForm.dob.value;

	if (date == null || date == "") {
		alert("Date Should not be null or empty ");
		document.forms.regForm.dob.focus();
		return false;
	}

	var email = document.forms.regForm.Email_Id.value;
	var mail = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;

	if (email == null || email == "") {
		alert("Email_Id Should not be null or empty ");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	if (!name.test(email)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	if (!mail.test(email)) {
		alert("Please give valid email Id");
		document.forms.regForm.Email_Id.focus();
		return false;
	}

	var phone = document.forms.regForm.Mobile_Number.value;

	if (isNaN(phone)) {
		alert("Please enter numeric value for phone number");
		document.forms.regForm.Mobile_Number.focus();
		return false;
	}
	var phn = /^\S*$/;

	if (!phn.test(phone)) {
		alert("White spaces are not allowed in Phone");
		document.forms.regForm.Mobile_Number.focus();
		return false;
	}

	if (phone.length > 10 || phone.length < 10) {
		alert("Mobile number length should be 10");
		document.forms.regForm.Mobile_Number.focus();
		return false;
	}

	/*
	 * var address = document.forms.regForm.Address.value;
	 * 
	 * if (address == "" || address == null) { alert("Address Should not be null
	 * or empty"); document.forms.regForm.Address.focus(); return false; }
	 */

	var location = document.forms.regForm.Location.value;
	var name = /^\S/;

	if (location == "" || location == null) {
		alert("Location Should not be null or empty");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (isNaN(location) == false) {
		alert("Please give Characters in Location Field");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (location.length < 3) {
		alert("Minimum of 3 Characters required");
		document.forms.regForm.Location.focus();
		return false;
	}

	if (location.indexOf(" ") >= 0) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Location.focus();
		return false;
	}

	/*
	 * var pinCode = document.forms.regForm.Pin_Code.value;
	 * 
	 * if (isNaN(pinCode)) { alert("Please enter numeric value for PinCode");
	 * document.forms.regForm.Pin_Code.focus(); return false; }
	 * 
	 * if (pinCode.indexOf(" ") >= 0) { alert("White spaces are not allowed in
	 * PinCode"); document.forms.regForm.Pin_Code.focus(); return false; }
	 * 
	 * if (pinCode.length > 6 || pinCode.length < 6) { alert("PinCode length
	 * should be 6"); document.forms.regForm.Pin_Code.focus(); return false; }
	 */

	var file = document.forms.regForm.file.value;

	if (file == "") {
		alert("Image File Should not be null or empty,Please select the file");
		document.forms.regForm.file.focus();
		return false;
	}

	var username = document.forms.regForm.User_Name.value;

	if (username == null || username == "") {
		alert("UserName Should not be null or empty ");
		document.forms.regForm.User_Name.focus();
		return false;
	}

	if (!name.test(username)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.User_Name.focus();
		return false;
	}

	if (username.length < 6) {
		alert("Minimum of 6 Characters required");
		document.forms.regForm.User_Name.focus();
		return false;
	}

	var pwd1 = document.forms.regForm.Password1.value;

	if (pwd1 == null || pwd1 == "") {
		alert("Password Should not be null or empty ");
		document.forms.regForm.Password1.focus();
		return false;
	}

	if (!name.test(pwd1)) {
		alert("White Space is not allowed\n Pleas enter valid characters");
		document.forms.regForm.Password1.focus();
		return false;
	}

	if (pwd1.length < 6) {
		alert("Minimum of 6 Characters required");
		document.forms.regForm.Password1.focus();
		return false;
	}

	var pwd2 = document.forms.regForm.Password2.value;

	if (pwd2 != pwd1) {
		alert("Password Mismatch\n Please Enter same Password");
		document.forms.regForm.Password2.focus();
		return false;
	}
}

// Request VM Validation
function requestVMValidate() {

	var VmRequest = document.forms.requestVMForm.VmRequest.value;

	if (VmRequest == null || VmRequest == "") {
		alert("Please enter the Subject");
		document.forms.requestVMForm.VmRequest.focus();
		return false;
	}

	if (!isNaN(VmRequest)) {
		alert("don't enter numaric values for Subject ");
		document.forms.requestVMForm.VmRequest.focus();
		return false;
	}

}

// Provide VM Validation
function providingVMValidate() {

	var totalMemory = document.forms.providingVMForm.totalMemory.value;

	if (totalMemory == "--Select--") {
		alert("Please Select the VM");
		document.forms.providingVMForm.totalMemory.focus();
		return false;
	}

}

// Upload Validation
function fileUploadValidate() {
	var file = document.forms.uploadForm.file.value;
	if (file == null || file == "") {
		alert("Please select .txt file");
		document.forms.uploadForm.file.focus();
		return false;
	}
}

// Set FileName
var openFile = function(event) {
	var input = event.target;
	onchange = document.getElementsByName('fileName')[0].value = document
			.getElementById('file').value.replace(/^.*[\\\/]/, '');
	var reader = new FileReader();
	reader.onload = function() {
		var text = reader.result;
		var node = document.getElementById('output');
		node.innerText = text;
		console.log(reader.result.substring(0, 200));

	};
	reader.readAsText(input.files[0]);
};

function taskFormValidate() {
	var fileName = document.forms.taskForm.fileName.value;

	if (fileName == "--Select File--") {
		alert("Please Select the fileName");
		document.forms.taskForm.fileName.focus();
		return false;
	}
}

function updateFormValidate() {
	var content = document.forms.updateForm.content.value;

	if (content == "" || content == null) {
		alert("Content Should not be NULL or empty");
		document.forms.updateForm.content.focus();
		return false;
	}
}

// Search FileName
function searchValidate() {

	var keyword = document.forms.serachForm.keyword.value;

	if (keyword == null || keyword == "") {
		alert("Please enter the keyword");
		document.forms.serachForm.keyword.focus();
		return false;
	}

	if (!isNaN(keyword)) {
		alert("don't enter numaric values for keyword ");
		document.forms.serachForm.keyword.focus();
		return false;
	}

}

// Done

// Download form Validation
function downloadFormValidate() {

	var fileName = document.forms.downloadForm.fileName.value;
	var secretKey = document.forms.downloadForm.secretKey.value;

	if (fileName == null || fileName == "") {
		alert("FileName should not be null or empty \n please enter .txt extension");
		document.forms.downloadForm.fileName.focus();
		return false;
	}

	if (secretKey == null || secretKey == "") {
		alert("SecretKey should not be null");
		document.forms.downloadForm.secretKey.focus();
		return false;
	}
}

// Download
function doDL() {

	var s = document.getElementById("myTextArea").value;
	function dataUrl(data) {
		return "data:x-application/text," + escape(data);
	}
	window.open(dataUrl(s));
}
