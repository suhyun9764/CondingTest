t = int(input())  # 테스트 케이스의 수

for _ in range(t):
    n = int(input())  # 지원자의 수
    applicants = []  # 지원자 정보를 저장할 리스트

    # 지원자 정보 입력받기
    for _ in range(n):
        document_rank, interview_rank = map(int, input().split())
        applicants.append((document_rank, interview_rank))

    # 서류심사 순위를 기준으로 오름차순 정렬
    applicants.sort()

    # 가장 높은 면접심사 순위 저장
    max_interview_rank = applicants[0][1]
    count = 1  # 첫 번째 지원자는 반드시 채용되므로 count를 1로 초기화

    # 두 번째 지원자부터 순회하면서 채용 가능한지 확인
    for i in range(1, n):
        if applicants[i][1] < max_interview_rank:
            count += 1
            max_interview_rank = applicants[i][1]

    print(count)  # 채용된 사원 수 출력
