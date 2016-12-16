package com.fuzhu.studentmanager;

import java.util.List;

public class StudentDAOProxy  implements IStudentDAO {
		private StudentDAOImpl dao=new StudentDAOImpl(); 
		public StudentDAOProxy(){
		}
		public Student findStudent(String  name) throws Exception{
			Student student_search = null;
			student_search = this.dao.findStudent(name);
			return student_search;
		}
		@Override
		public Student insertStudent(Student student) throws Exception {
			// TODO Auto-generated method stub
			Student student_search = null;
			student_search = this.dao.insertStudent(student);
			return student_search;
		}
		@Override
		public Student deleteStudent(String name) throws Exception {
			Student student_search = null;
			student_search = this.dao.deleteStudent(name);
			return student_search;
		}
		@Override
		public Student updateStudent(String  proviousName,String nowName) throws Exception {
			// TODO Auto-generated method stub
			Student student_search = null;
			student_search = this.dao.updateStudent(proviousName, nowName);
			return student_search;
		}
		@Override
		public List StSelect() throws Exception {
			// TODO Auto-generated method stub
			List list= this.dao.StSelect();
			return list;
		}
}
