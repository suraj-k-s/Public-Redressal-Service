
var state_arr = new Array("Andaman & Nicobar Islands", "Andhra Pradesh","Arunachal Pradesh","Assam","Bihar",
                            "Chandigarh","Chhattisgarh","Dadra & Nagar Haveli","Daman & Diu","Delhi","Goa",
                            "Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka",
                            "Kerala","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram",
                            "Nagaland","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Tripura",
                            "Uttar Pradesh","Uttarakhand","West Bengal");

// States
var s_a = new Array();
s_a[0]="";
s_a[1]="";
s_a[2]="";
s_a[3]="";
s_a[4]="";
s_a[5]="";
s_a[6]="";
s_a[7]="";
s_a[8]="";
s_a[9]="";
s_a[10]="";
s_a[11]="";
s_a[12]="";
s_a[13]="";
s_a[14]="";
s_a[15]="";
s_a[16]="";
s_a[17]="Bagalkot|Ballari|Belagavi|Bangalore|Bidar|Chamarajanagar|Chikballapur|Chikkamagaluru|Chitradurga|Dakshina Kannada|Davangere|Dharwad|Gadag|Hassan|Haveri|Kalaburagi|Kodagu|Kolar|KoppalMandya|Mysore|Raichur|Ramanagara|Shivamogga|Tumakuru|Udupi|Uttara Kannada|Vijayapura|Yadgir";
s_a[18]="Alappuzha|Ernakulam|Idukki|Kannur|Kasargod|Kollam|Kottayam|Kozhikode|Malappuram|Palakkad|Pathanamthitta|Thiruvananthapuram|Thrissur|Wayanad";
s_a[19]="";
s_a[20]="";
s_a[21]="";
s_a[22]="";
s_a[23]="";
s_a[24]="";
s_a[25]="";
s_a[26]="";
s_a[27]="";
s_a[28]="";
s_a[29]="";
s_a[30]="";
s_a[31]="Chingleput|Coimbatore|Kanyakumari|Madras|Madurai|Nilgiris|North Arcot|Ramanathapuram|Salem|South Arcot|Thanjavur|Tiruchirappalli|Tirunelveli";
s_a[32]="";
s_a[33]="";
s_a[34]="";
s_a[35]="";

function populateDistricts( stateElementId, districtElementId ){
	
	var selectedStateIndex = document.getElementById( stateElementId ).selectedIndex;

	var stateElement = document.getElementById( districtElementId );
	
	stateElement.length=0;	// Fixed by Julian Woods
	stateElement.options[0] = new Option('Select District','');
	stateElement.selectedIndex = 0;
	
	var state_arr = s_a[selectedStateIndex].split("|");
	
	for (var i=0; i<state_arr.length; i++) {
		stateElement.options[stateElement.length] = new Option(state_arr[i],state_arr[i]);
	}
}

function populateStates(stateElementId, districtElementId){
	// given the id of the <select> tag as function argument, it inserts <option> tags
	var stateElement = document.getElementById(stateElementId);
	stateElement.length=0;
	stateElement.options[0] = new Option('Select State','-1');
	stateElement.selectedIndex = 0;
	for (var i=0; i<state_arr.length; i++) {
		stateElement.options[stateElement.length] = new Option(state_arr[i],state_arr[i]);
	}

	// Assigned all countries. Now assign event listener for the states.

	if( districtElementId ){
		stateElement.onchange = function(){
			populateDistricts( stateElementId, districtElementId );
		};
	}
}