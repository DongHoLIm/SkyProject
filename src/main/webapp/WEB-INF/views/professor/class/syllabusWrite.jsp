<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.inputbox {
	border: none;
	box-shadow: none !important;
	width: 100%;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="main">
			<div class="inner">
				<jsp:include page="../../common/header.jsp" />
				<br>
				<h2>강의 계획서 작성</h2>
				<br>


				<!-- 강좌정보 -->
				<table>

					<tbody>
						<tr style="bgcolor:ffffff; height:5%;">
							<td bgcolor="E7EEE3" align="center" width=12%><b>교과목명</b></td>
							<td>&nbsp;<input type="text"
								style="border: none; box-shadow: none !important; width:100%;"
								class="inputbox"></td>
							<td bgcolor="E7EEE3" align="center" width="80"><b>학수번호</b></td>
							<td align="left">&nbsp;KY101-A</td>
							<td bgcolor="E7EEE3" align="center" width="100"><b>소속학과</b></td>
							<td align="left">&nbsp;교양과정</td>
						</tr>

						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>수강대상</b></td>
							<td align="left">&nbsp;12 학년</td>
							<td bgcolor="E7EEE3" align="center"><b>수업교시</b></td>
							<td align="left">&nbsp;월09</td>
							<td bgcolor="E7EEE3" align="center"><b>담당교수</b></td>
							<td align="left">&nbsp;나현기,김남석</td>
						</tr>

						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>이수구분</b></td>
							<td align="left">&nbsp;교양필수</td>
							<td bgcolor="E7EEE3" align="center"><b>교과구분</b></td>
							<td align="left">&nbsp;</td>
							<td bgcolor="E7EEE3" align="center"><b>인증구분</b></td>
							<td align="left">&nbsp;</td>
						</tr>


						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>학점/시간/성적</b></td>
							<td align="left" colspan="3">&nbsp;.5학점(이론:1, 실험및실습:0, 설계:0)
								/ 1시간 / P</td>
							<td bgcolor="E7EEE3" align="center"><b>수업방식</b></td>
							<td align="left">&nbsp;강의식</td>
						</tr>

						<!-- 핵심역량 : 2019.01.08 -->
						<tr bgcolor="ffffff" height="25">
							<td bgcolor="E7EEE3" align="center"><b>인재상</b></td>
							<td colspan="5">
								<table>
									<tbody>
										<tr height="25">
											<td bgcolor="E7EEE3" align="center" colspan="2"><b>소통하는
													지성인</b></td>
											<td bgcolor="E7EEE3" align="center" colspan="2"><b>도전하는
													창의인</b></td>
											<td bgcolor="E7EEE3" align="center" colspan="2"><b>실천하는
													평화인</b></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>

						<tr bgcolor="ffffff" height="50">
							<td bgcolor="E7EEE3" align="center"><b>핵심역량</b></td>
							<td colspan="5">
								<table>
									<tbody>
										<tr height="25">
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>인문</b></td>
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>소통</b></td>
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>지식정보</b></td>
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>창의융합</b></td>
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>글로벌</b></td>
											<td bgcolor="E7EEE3" align="center" width="16.6%"><b>리더십</b></td>
										</tr>
										<tr height="25">
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
											<td bgcolor="ffffff" align="center">&nbsp;0&nbsp;</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>

						<!-- 수업개요 -->
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>수업개요</b></td>
							<td align="left" colspan="5"
								style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">다양한
								예배와 특강을 통해서 기독교적 인간관, 가치관, 역사관, 세계관을 지닌 건강한 인간 형성을 목표로 한다.</td>
						</tr>

						<!-- 수업목표및내용 -->
						<tr bgcolor="ffffff" height="60">
							<td bgcolor="E7EEE3" align="center"><b>수업목표<br>및<br>내용
							</b></td>
							<td align="left" colspan="5"
								style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">2019년
								2학기 채플의 주제는 "평화의 일꾼이 되자!"(마태복음 5:9)이다. ''''평화와 하나됨''''이라는 주제로
								재학생들을 포함하는 다양한 강사들의 특강, 교목들의 말씀 채플, 그리고 문화 채플이 제공될 것이다.</td>
						</tr>

						<!-- 수업운영방식 -->
						<tr bgcolor="ffffff" height="60">
							<td bgcolor="E7EEE3" align="center"><b>수업운영방식<br>및<br>평가지침
							</b></td>
							<td align="left" colspan="5"
								style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">말씀채플,
								특강채플, 문화채플 형식으로 주로 강사의 특강위주로 진행될 것이다.<br> 성적은 출석에 따른 P/NP로
								결정한다.
							</td>
						</tr>

						<!-- 과제 -->
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>과제 1</b></td>
							<td align="left" colspan="5">&nbsp;별도 과제 없음.</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>과제 2</b></td>
							<td align="left" colspan="5">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>과제 3</b></td>
							<td align="left" colspan="5">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>과제 4</b></td>
							<td align="left" colspan="5">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>과제 5</b></td>
							<td align="left" colspan="5">&nbsp;</td>
						</tr>

						<!-- 수업참고도서(교재포함) -->
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center" rowspan="6"><b>수업<br>참고도서<br>(교재포함)
							</b></td>
							<td bgcolor="E7EEE3" align="center"><b>서명</b></td>
							<td bgcolor="E7EEE3" align="center"><b>저자</b></td>
							<td bgcolor="E7EEE3" align="center"><b>출판사</b></td>
							<td bgcolor="E7EEE3" align="center"><b>출판년도</b></td>
							<td bgcolor="E7EEE3" align="center"><b>ISBN</b></td>
						</tr>

						<tr bgcolor="ffffff" height="20">
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
						</tr>
						<tr bgcolor="ffffff" height="20">
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
							<td align="left">&nbsp;</td>
						</tr>

						<!-- 수업진행계획(주차별 혹은 시간별) -->
						<tr bgcolor="ffffff" height="25">
							<td bgcolor="E7EEE3" align="center" colspan="6"><b>수업진행계획(주차별
									혹은 시간별)</b></td>
						</tr>
						<tr bgcolor="ffffff" height="25">
							<td align="left" colspan="6"
								style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">1주(9/9)
								: 하종문 교수<br> 2주(9/16) : 한신대 사회봉사단<br> 3주(9/23) : 성폭력
								방지 및 인권 교육<br> 4주(9/30) : CCM 래퍼 다비드<br> 5주(10/7) :
								김영호 대표<br> 6주(10/14) : 강은미 목사<br> 7주(10/28) : 유동석 교수<br>
								8주(11/4) : 한신대 학생상담센터<br> 9주(11/11) : 한신대 IT경영학과 클라리넷 연주팀<br>
								10주(11/18) : 나현기 교목<br>
							</td>
						</tr>
					</tbody>
				</table>
				<br>
				<table>
					<!-- 연구실 정보 -->
					<tbody>
						<tr bgcolor="ffffff" height="20">
							<td bgcolor="E7EEE3" align="center"><b>연구실</b></td>
							<td align="left">&nbsp;4202 / 031-379-0011</td>
							<td bgcolor="E7EEE3" align="center"><b>E-mail</b></td>
							<td align="left">&nbsp;alm-1@hanmail.net</td>
							<td bgcolor="E7EEE3" align="center"><b>휴대폰</b></td>
							<td align="left">&nbsp;-</td>
						</tr>

					</tbody>
				</table>


				<!-- 장애학생 -->
				<table>
					<tbody>
						<tr bgcolor="#ffffff">
							<td align="left" style="padding-top: 10px;">＊ 장애학생은
								장애학생지원센터(031-379-0049)에서 필요한 교수학습지원을 받으실 수 있습니다.</td>
						</tr>
					</tbody>
				</table>


				<br>
			</div>
		</div>
		<div>
			<jsp:include page="../../common/menubar-student.jsp" />
		</div>
	</div>
</body>
</html>