#!/usr/bin/awk −f
BEGIN{ 
} 

{ 
	if($3 == "Valor="){ 
		print $4;
	}
}
END{
} 
