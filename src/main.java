import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException {
//        최초 실행시
//        file.toDate();

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

        Start.start();

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);

    }
}

// plt파일 정제
// 날짜 별 정리
// 시간 순 시간단위 파일 생성
// 시간 순 정렬 된 파일 k-means 함수
// 시간 당 밀집 지역의 좌표 출력
// 해당 좌표에 있던 사람의 목록도 같이 출력
