package xmu.crms.service;

import static org.junit.Assert.assertNotNull;
import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xmu.crms.CourseManageApplication;
import xmu.crms.entity.ClassInfo;
import xmu.crms.entity.Location;
import xmu.crms.entity.Seminar;
import xmu.crms.exception.ClassesNotFoundException;
import xmu.crms.exception.CourseNotFoundException;
import xmu.crms.exception.InvalidOperationException;
import xmu.crms.exception.SeminarNotFoundException;
import xmu.crms.exception.UserNotFoundException;
import xmu.crms.service.ClassService;

/**
 * URL-pattern:prefix="/class"
 * 
 * @author ZDD、Huhui
 * @date 2017-12-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CourseManageApplication.class)
public class ClassServiceTest {
	@Autowired
	private ClassService classService;

	@Test
	public void deleteClassSelectionByClassId() {
		classService.deleteClassSelectionByClassId(new BigInteger("1"));
	}

	@Test
	public void listClassByName() {
		List<ClassInfo> flag = null;

		String courseName = "课程1";
		String teacherName = "邱明";
		try {
			flag = classService.listClassByName(courseName, teacherName);
			System.err.println(flag);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(flag);
	}

	@Test
	public void listClassByCourseId() {
		List<ClassInfo> flag = null;

		try {
			flag = classService.listClassByCourseId(new BigInteger("1"));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(flag);
	}

	@Test
	public void getClassByClassId() {
		ClassInfo flag = null;

		try {
			flag = classService.getClassByClassId(new BigInteger("1"));
			System.err.println(flag);
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(flag);
	}

	@Test
	public void updateClassByClassId() {

		try {
			ClassInfo classInfo = new ClassInfo();
			classInfo.setId(new BigInteger("2"));
			classInfo.setName("万一呢");
			classService.updateClassByClassId(new BigInteger("2"), classInfo);
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void deleteClassByClassId() {

		try {
			classService.deleteClassByClassId(new BigInteger("2"));
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void insertCourseSelectionById() {
		BigInteger flag = null;

		try {
			flag = classService.insertCourseSelectionById(new BigInteger("3"), new BigInteger("1"));
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(flag);
	}

	@Test
	public void deleteCourseSelectionById() {

		try {
			classService.deleteCourseSelectionById(new BigInteger("11"), new BigInteger("1"));
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void insertClassById() {
		BigInteger flag = null;

		try {
			ClassInfo classInfo = new ClassInfo();
			classInfo.setName("dsdaasdas");
			flag = classService.insertClassById(new BigInteger("1"), classInfo);
			System.out.println(flag);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNotNull(flag);
	}

	@Test
	public void deleteClassByCourseId() {

		try {
			ClassInfo classInfo = new ClassInfo();
			classInfo.setName("dsdaasdas");
			classService.deleteClassByCourseId(new BigInteger("1"));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	@Test
	public void getCallStatusById() {
		Location location = null;
		try {
			location = classService.getCallStatusById(new BigInteger("1"), new BigInteger("1"));
			assertNotNull(location);
			location = classService.getCallStatusById(new BigInteger("2"), new BigInteger("2"));
		} catch (SeminarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void callInRollById() {
		Location location = new Location();
		ClassInfo classInfo=new ClassInfo();
		classInfo.setId(new BigInteger("1"));
		Seminar seminar=new Seminar();
		seminar.setId(new BigInteger("1"));
		location.setClassInfo(classInfo);
		location.setSeminar(seminar);
		BigInteger flag;
		try {
			flag = classService.callInRollById(location);
			assertNotNull(location);
			location.getClassInfo().setId(new BigInteger("128"));
			flag = classService.callInRollById(location);
			location.getSeminar().setId(new BigInteger("128"));
			flag = classService.callInRollById(location);
		} catch (SeminarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void endCallRollById() {
		Location location = new Location();
		ClassInfo classInfo=new ClassInfo();
		classInfo.setId(new BigInteger("1"));
		Seminar seminar=new Seminar();
		seminar.setId(new BigInteger("1"));
		location.setClassInfo(classInfo);
		location.setSeminar(seminar);
		location.setStatus(2);
		BigInteger flag;
		try {
			classService.endCallRollById(location);
			location.getClassInfo().setId(new BigInteger("128"));
			flag = classService.callInRollById(location);
			location.getSeminar().setId(new BigInteger("128"));
			flag = classService.callInRollById(location);
		} catch (SeminarNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void listClassByUserId() {
		try {
			List<ClassInfo> classInfo= classService.listClassByUserId(new BigInteger("7"));
			System.err.println(classInfo);
			assertNotNull(classInfo);
			
		} catch (ClassesNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
