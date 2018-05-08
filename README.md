# VideoRental

비디오 대여점에서 고객의 대여료 내역을 계산하고 출력하는 프로그램
 - 고객이 대여한 비디오와 대여 기간을 표시
 - 비디오 종류와 대여 기간을 바탕으로 대여료를 계산
 - 비디오 종류 : 일반, 유아, 신작
 - 적립 포인트 계산 (신작의 경우 계산 로직이 달라짐)
 
 
# Legacy Code Test Case 작성
- JUnit Test Coverage가 100%가 되도록 작성
- Shortest Line부터 작성유의미한 TestCase명 사용(한글 써도 됨)

# Test Case Refactoring
- 중복해서 선언된 지역변수를 변환하여 중복을 제거
- 의미를 알 수 없는 숫자, 문자열은 의미를 알아볼 수 있는 상수로 치환
- 간단한 수식을 대입 받는 임시변수를 수식으로 변환코드를 묶어 직관적인 이름의 메소드 추출

# Legacy Code Refactoring
- Legacy Code에서 Code Smell을 발견하고 해결
- 업무 로직을 고려한 Refactoring 
