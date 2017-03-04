package doa;


public class UserAgent {
	String os = "";
	String browser = "";

	public String getOs() {
		return os;
	}

	public String getBrowser() {
		return browser;
	}
	public String getOsAndBrowserInfo(String userAgent){
	        String  user            =   userAgent.toLowerCase();
	        //=================OS Info=======================
	        int num;
			if (user.indexOf("windows") >= 0 )
	        {
	            os = "Windows";
	        } else if(user.indexOf("mac") >= 0)
	        {
	            os = "Mac";
	        } else if(( num = user.indexOf("android")) >= 0)
	        {
	            os = userAgent.substring(num).split(";")[0];
	        } else if(user.indexOf("iphone") >= 0)
	        {
	            os = "IPhone";
	        } 
	        else if(user.contains("linux")){
	        	os = "Linux";
	        } else if(user.indexOf("x11") >= 0)
	        {
	            os = "Unix";
	        }
	        else{
	            os = "UnKnown, More-Info: "+userAgent;
	        }
	        //===============Browser===========================
	        if (user.contains("edge"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Edge")).split(" ")[0]).replace("/", "-");
	        } else if (user.contains("msie"))
	        {
	            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
	            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
	        } else if (user.contains("safari") && user.contains("version"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]
	                    + "-" +(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
	        } else if ( user.contains("opr") || user.contains("opera"))
	        {
	            if(user.contains("opera")){
	                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]
	                        +"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
	            }else if(user.contains("opr")){
	                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
	                        .replace("OPR", "Opera");
	            }

	        } else if (user.contains("chrome"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
	        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  ||
	                (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) ||
	                (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
	        {
	            browser = "Netscape-?";

	        } else if (user.contains("firefox"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
	        } else if(user.contains("rv"))
	        {
	            String IEVersion = (userAgent.substring(userAgent.indexOf("rv")).split(" ")[0]).replace("rv:", "-");
	            browser="IE" + IEVersion.substring(0,IEVersion.length() - 1);
	        } else
	        {
	            browser = "UnKnown, More-Info: "+userAgent;
	        }

	        return os +" --- "+ browser ;
	    }
}
