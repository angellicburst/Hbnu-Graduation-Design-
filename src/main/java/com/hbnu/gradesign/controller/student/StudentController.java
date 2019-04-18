package com.hbnu.gradesign.controller.student;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbnu.gradesign.entity.dto.StudentDto;
import com.hbnu.gradesign.entity.pojo.PackData;
import com.hbnu.gradesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class StudentController {

	@Autowired
	private StudentService ss;


	/**
	 * admin
	 * 获取所有学生
	 * @param pageIndex
	 * @param pageSize
	 * @param studentDto
	 * @return
	 */
	@RequestMapping(value = "/admin/getStudents",method = RequestMethod.GET)
	public PackData getStuAdmin(@RequestParam(value = "page", defaultValue = "1") String pageIndex,
								@RequestParam(value = "limit", defaultValue = "10") String pageSize,
								StudentDto studentDto) {
		PageHelper.startPage(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
		PackData packData = ss.getStusAdm(studentDto);
		PageInfo pageInfo = new PageInfo(packData.getObjs());

		packData.setCount((int) pageInfo.getTotal());

		return packData;
	}

	/**
	 * 批量导入学生模板下载下载
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/admin/template/download",method = RequestMethod.GET)
	public PackData templateDownLoad(HttpServletResponse response) throws UnsupportedEncodingException {
		return ss.templateDownLoad(response);
	}

	/**
	 * excel批量添加学生
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/admin/addStudent",method = RequestMethod.POST)
	public PackData addStudent(@RequestParam("file") MultipartFile file) throws Exception {
		return ss.addStudentsByExcel(file);
	}



}
