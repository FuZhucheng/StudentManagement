package com.fuzhu.studentmanager;

public class Student {
		private  int STID;						//学号
		private String STNAME;				//姓名
		private String STSEX;						//性别
		private String  STAGE;					//年龄
		private String  STPHONE;				//电话

		public String getSTAGE() {
			return STAGE;
		}
		public void setSTAGE(String sTAGE) {
			STAGE = sTAGE;
		}
//		private String 	MATH;				//数学成绩
//		private String ENGLISH;			//英语成绩
//		private String CHINESE;			//语文成绩
//	
//		public String getMATH() {
//			return MATH;
//		}
//		public void setMATH(String mATH) {
//			MATH = mATH;
//		}
//		public String getENGLISH() {
//			return ENGLISH;
//		}
//		public void setENGLISH(String eNGLISH) {
//			ENGLISH = eNGLISH;
//		}
//		public String getCHINESE() {
//			return CHINESE;
//		}
//		public void setCHINESE(String cHINESE) {
//			CHINESE = cHINESE;
//		}
	
		public String getSTPHONE() {
			return STPHONE;
		}
		public void setSTPHONE(String sTPHONE) {
			STPHONE = sTPHONE;
		}
		public int getSTID() {
			return STID;
		}
		public void setSTID(int sTID) {
			STID = sTID;
		}
		public String getSTNAME() {
			return STNAME;
		}
		public void setSTNAME(String sTNAME) {
			STNAME = sTNAME;
		}
		public String getSTSEX() {
			return STSEX;
		}
		public Student(int sTID, String sTNAME, String sTSEX, String sTAGE, String sTPHONE, String mATH, String eNGLISH,
				String cHINESE) {
			super();
			this.STID = sTID;
			this.STNAME = sTNAME;
			this.STSEX = sTSEX;
			this.STAGE = sTAGE;
			this.STPHONE = sTPHONE;
//			this.MATH = mATH;
//			this.ENGLISH = eNGLISH;
//			this.CHINESE = cHINESE;
		}
		
		public Student(int sTID, String sTNAME, String sTSEX, String sTAGE, String sTPHONE) {
			super();
			STID = sTID;
			STNAME = sTNAME;
			STSEX = sTSEX;
			STAGE = sTAGE;
			STPHONE = sTPHONE;
		}
		public void setSTSEX(String sTSEX) {
			STSEX = sTSEX;
		}
		public Student(){
			
		}
	
		
		
}
