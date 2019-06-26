package com.greathiit.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greathiit.entity.SpecialtySituationAnalysis;
import com.greathiit.entity.StudentSituationAnalysis;
import com.greathiit.entity.TeacherSituationAnalysis;
import com.greathiit.excel.ExcelFactory;

import cn.afterturn.easypoi.excel.entity.ExportParams;

@Controller
public class ExcelHandler {
 @SuppressWarnings("unchecked")
 @RequestMapping("/*/downloadClassLeave")
 public void downloadClassLeave(HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
	 List<StudentSituationAnalysis> list = (List<StudentSituationAnalysis>) session.getAttribute("classSituationAnalysis");
	 if(list == null || list.size() == 0) {
		 response.sendRedirect("studentLeaveStatisticsInfo.html");
		 return ;
	 }
	 List<StudentSituationAnalysis> dataList = null;
	 /**存储表格数据的集合**/
	 List<Map<String,Object>> data = new ArrayList<>();
	 /**存储每个sheet的数据集合**/
	 Map<String,Object> map = null;
	 /**当前数据班级名**/
	 String now = null;
	 /**下一条数据班级名**/
	 String next = null;
	 /**上一条数据班级名**/
	 String last = null;
	 if(list != null) {
		 for(int i=0;i<list.size();i++) {
			 if(list.size()==1) {
				 map = new HashMap<>(1);
				 ExportParams params = new ExportParams(list.get(0).getStudentName()+"请假信息",list.get(0).getStudentName());
				 	map.put("title",params);
				 	map.put("entity", StudentSituationAnalysis.class);
				 	map.put("data", list);
				 	data.add(map);
				 	break;
			 }
		 //i=0 将第一个班级名赋值给now 和 last 将第二条数据班级名赋值给next 并实例化初始数据集合
		 else if(i==0&&list.size()>1) {
			 last = now = list.get(i).getStudentName();
			 next = list.get(i+1).getStudentName();
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 else if(i+1<list.size()) {
			last = list.get(i-1).getStudentName();
		 	now = list.get(i).getStudentName();
		 	next = list.get(i+1).getStudentName();
		 }else {
			 last = list.get(i-1).getStudentName();
			 now = next = list.get(i).getStudentName();
		 }
		 //现在的班级名和上一条数据班级名不一致说明班级已换该实例化新的数据集合
		 if(!now.equals(last)) {
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 //现在班级名和下一条数据班级名不一致说明该班级数据已存完毕 放入一个sheet中 
		 //或者是最后一条数据肯定要装入一个sheet中
		 if(!now.equals(next)||(i==list.size()-1)) {
			 ExportParams params = new ExportParams(now+"请假信息",now);
			 	map.put("title",params);
			 	map.put("entity", StudentSituationAnalysis.class);
			 	map.put("data", dataList);
			 	data.add(map);
		 }
		 dataList.add(list.get(i));
	 }
	 ExcelFactory.exportExcel(data, list.get(0).getClassName()+"班请假信息表.xls", response);
	 }
 }
 
@SuppressWarnings("unchecked")
@RequestMapping("/*/downloadSpecialtyLeave")
 public void downloadSpecialtyLeave(HttpServletResponse response,HttpSession session) throws IOException {
	 List<SpecialtySituationAnalysis> list=(List<SpecialtySituationAnalysis>) session.getAttribute("specialtyStatistics");
	 List<SpecialtySituationAnalysis> dataList = null;
	 if(list == null || list.size() == 0) {
		 response.sendRedirect("othersLeaveStatisticsInfo.html");
		 return ;
	 }
	 /**存储表格数据的集合**/
	 List<Map<String,Object>> data = new ArrayList<>();
	 /**存储每个sheet的数据集合**/
	 Map<String,Object> map = null;
	 /**当前数据专业名**/
	 String now = null;
	 /**下一条数据专业名**/
	 String next = null;
	 /**上一条数据专业名**/
	 String last = null;
	 for(int i=0,j=list.size();i<j;i++) {
		 //i=0 将第一个专业名赋值给now 和 last 将第二条数据专业名赋值给next 并实例化初始数据集合
		 if(j==1) {
			 last = now = list.get(i).getSpecialtyName();
			 next = list.get(i).getSpecialtyName();
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 else if(i<1&&i+1<j) {
			 last = now = list.get(i).getSpecialtyName();
			 next = list.get(i+1).getSpecialtyName();
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 else if(i+1<j) {
			last = list.get(i-1).getSpecialtyName();
		 	now = list.get(i).getSpecialtyName();
		 	next = list.get(i+1).getSpecialtyName();
		 }else {
			 last = list.get(i-1).getSpecialtyName();
			 now = next = list.get(i).getSpecialtyName();
		 }
		 //现在的专业名和上一条数据专业名不一致说明专业已换该实例化新的数据集合
		 if(!now.equals(last)) {
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 //现在专业名和下一条数据专业名不一致说明该专业数据已存完毕 放入一个sheet中 
		 //或者是最后一条数据肯定要装入一个sheet中
		 if(!now.equals(next)||(i==j-1)) {
			 ExportParams params = new ExportParams(now+"请假信息",now);
			 	map.put("title",params);
			 	map.put("entity", SpecialtySituationAnalysis.class);
			 	map.put("data", dataList);
			 	data.add(map);
		 }
		 dataList.add(list.get(i));
	 }
	 ExcelFactory.exportExcel(data, "请假信息表.xls", response);

 }
@SuppressWarnings("unchecked")
@RequestMapping("/*/downloadTeacherStatistics")
 public void downloadTeacherStatistics(HttpServletResponse response,HttpSession session) throws IOException {
	 List<TeacherSituationAnalysis> list=(List<TeacherSituationAnalysis>) session.getAttribute("teacherStatistics");
	 List<TeacherSituationAnalysis> dataList = null;
	 if(list == null || list.size() == 0) {
		 response.sendRedirect("teacherLeaveStatisticsInfo.html");
		 return ;
	 }
	 /**存储表格数据的集合**/
	 List<Map<String,Object>> data = new ArrayList<>();
	 /**存储每个sheet的数据集合**/
	 Map<String,Object> map = null;
	 /**当前数据专业名**/
	 String now = null;
	 /**下一条数据专业名**/
	 String next = null;
	 /**上一条数据专业名**/
	 String last = null;
	 for(int i=0,j=list.size();i<j;i++) {

		 if(j==1) {
			 last = now = list.get(i).getFacultyName();
			 next = list.get(i).getFacultyName();
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 else if(i<1&&i+1<j) {
			 last = now = list.get(i).getFacultyName();
			 next = list.get(i+1).getFacultyName();
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }
		 else if(i+1<j) {
			last = list.get(i-1).getFacultyName();
		 	now = list.get(i).getFacultyName();
		 	next = list.get(i+1).getFacultyName();
		 }else {
			 last = list.get(i-1).getFacultyName();
			 now = next = list.get(i).getFacultyName();
		 }

		 if(!now.equals(last)) {
			  map = new HashMap<>();
			  dataList = new ArrayList<>();
		 }

		 if(!now.equals(next)||(i==j-1)) {
			 ExportParams params = new ExportParams(now+"教师调课信息",now);
			 	map.put("title",params);
			 	map.put("entity", TeacherSituationAnalysis.class);
			 	map.put("data", dataList);
			 	data.add(map);
		 }
		 dataList.add(list.get(i));
	 }
	 ExcelFactory.exportExcel(data, "教师调课信息表.xls", response);

 }
}
