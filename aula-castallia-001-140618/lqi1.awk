#!/usr/bin/awk −f
BEGIN{
	t = 0
} 

{
	if(t != $2){ 

		for(i=t;i<$2;i++){
			print $1+2" "i;                            
                }	

		t = $2+1
	} else{
		
			t = t+1
		
	}
}
END{
} 
