#!/usr/bin/awk −f
BEGIN{ 
} 

{ 
	tStr = $5

	sub("#","",tStr)

	if($8 == "1"){ 
		print $1" "tStr;
	}
}
END{
} 
