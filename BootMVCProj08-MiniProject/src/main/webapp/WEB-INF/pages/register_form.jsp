<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<center>
<h1>Employee Registration Form</h1>
	<frm:form modelAttribute="employee">  <!-- By default its post and same path from where it called -->
		<table border="1px" style="background-color: cyan">
			<tr>
				<td>Name</td>
				<td>
					<frm:input path="empname"/>
				</td>
			</tr>
			<tr>
				<td>Designation</td>
				<td>
					<frm:input path="empdeg"/>
				</td>
			</tr>
			<tr>
				<td>Salary</td>
				<td>
					<frm:input path="empsalary"/>
				</td>
			</tr>
			<tr>
				<td>Department No</td>
				<td>
					<frm:select path="deptno">
						<frm:option value="10">10</frm:option>
						<frm:option value="20">20</frm:option>
						<frm:option value="30">30</frm:option>
						<frm:option value="40">40</frm:option>
					</frm:select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</table>
		<a href="./"><img src="images/home.png" height="40px" width="30px"><br>Home</a> <br>
	</frm:form>
</center>