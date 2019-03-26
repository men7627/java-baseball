/*
 *@(#)Game.java           1.0 2019/03/26
 *Copyright (c) 2019 Hyogeon Kim.
 *Number Baseball Game, Java, Mungyeong, KOREA
 */

import java.util.Random;
import java.util.Scanner;

/*
 * 야구게임에 관련 된 클래스
 * @version               1.0 2019년 03월 26일
 * @author                김효건
 */
public class Game {
    /* 게임시작 / 게임종료
     * 게임화면 출력 / 세자리 숫자 생성
     * 세자리 숫자 입력 / 세자리 숫자 검사
     * 정답 화면 출력
     * 메소드 구현
     *  */

    /*게임시작 시 랜덤으로 지정 될 세자리 숫자*/
    private Number gameNumber;

    /*사용자가 입력한 세자리 숫자*/
    private Number playerNumber;

    /*Game 클래스 생성자
     * 메뉴 출력 및 에러 출력
     * 종료 선택 시까지 반복
     * */
    Game(){
        while(true) {
            Menu.printMenu();

            /*선택 번호를 저장할 변수*/
            int select = Menu.selectMenu();
            if (select == 1)
                startGame();
            else if (select == 2)
                exitGame();
            else
                System.out.println("잘못 입력 하셨습니다.");
        }
    }

    /*게임 시작 함수 (전체적인 게임 진행)*/
    private void startGame(){
        printGame();
        makeRandomNumber();
        inputNumber();
    }

    /*게임 종료(프로그램 종료 함수)*/
    private void exitGame(){
        System.exit(0);
    }

    /*게임 화면 출력*/
    private void printGame(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    /*컴퓨터의 숫자를 랜덤으로 지정*/
    private void makeRandomNumber(){
        /*세 개의 숫자를 임시로 담을 변수, 최종적으로 gameNumber에 세팅*/
        int first=0, second=0, third=0;

        /*하나의 랜덤 숫자를 임의로 담을 변수*/
        Random rand = new Random();

        first = rand.nextInt(9)+1;

        do{
            second = rand.nextInt(9)+1;
        }while(first==second);

        do{
            third = rand.nextInt(9)+1;
        }while(first==third || second==third);

        gameNumber = new Number(first,second,third);
    }

    /*세개의 숫자를 입력받음*/
    private void inputNumber(){
        /*세자리 숫자를 입력받을 문자열*/
        String input;

        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        this.playerNumber = new Number(input.charAt(0)-'0',
                input.charAt(1)-'0',
                input.charAt(2)-'0');
    }
}
