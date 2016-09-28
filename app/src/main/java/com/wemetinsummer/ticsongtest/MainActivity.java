package com.wemetinsummer.ticsongtest;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    //public int MAX_QUIZ_NUM = 250; // 한 게임의 문제 개수
    //public int MAX_LIFE = 3; // 한 문제의 정답 기회
    public int MAX_TRACK_COUNT = 250; // 트랙 개수


    //public int gameMode = 0; // 0 : 문제 대기 중, 1 : 문제 내는 중, 2 : 맞추는 중, 3 : 정답 확인 중
    public ArrayList<Integer> itemArray = new ArrayList<Integer>(); // 아이템 개수 리스트
    // 아티스트 보여주기, 3초 듣기, 정답 1회 증가, 제목 한 글자 보여주기
    // 0 : 아이템 사용하지 않음, 1 : 아티스트 보여주기, 2 : 3초 듣기, 3 : 정답 1회 증가, 4 : 제목 한 글자 보여주기
    public int quizNum = 0; // 문제 번호

    //public CustomPreference pref;
    public ArrayList<String> answerArray = new ArrayList<String>(); // 정답 리스트
    public ArrayList<String> artistArray = new ArrayList<String>(); // 아티스트 리스트
    public ArrayList<String> addressArray = new ArrayList<String>(); // 트랙 주소 리스트
    public ArrayList<Integer> timeArray = new ArrayList<Integer>(); // 트랙 시작 지점(Millisec) 리스트
    public ArrayList<MediaPlayer> playerArray = new ArrayList<MediaPlayer>(); // MediaPlayer 리스트
    //public ArrayList<Integer> correctArray = new ArrayList<Integer>(); // 정답 여부 리스트, 맞출 때의 남은 기회 기록(pref로 전환)

    private ArrayList<String> str = new ArrayList<String>();
    private ArrayList<String> titleArray = new ArrayList<String>();
    private ArrayList<Integer> time = new ArrayList<Integer>();


    public MediaPlayer mPlayer;
    //Button playBtn, nextBtn, previousBtn;

    @Bind(R.id.next)
    Button nextBtn;
    @Bind(R.id.play)
    Button playBtn;
    @Bind(R.id.previous)
    Button previousBtn;
    @Bind(R.id.three)
    Button threeBtn;
    @Bind(R.id.longg)
    Button longBtn;

    public static int playNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        /*str.add("242860826");
        str.add("214268765");
        str.add("164984508");
        str.add("121047071");
        str.add("156044153");*/

        /*str.add("125769478");
        str.add("119016730");
        str.add("102944877");
                str.add("114819921");;;;;;;;;;;;;;;;;;;
        str.add("147341071");
        */

        /*      str.add("272517395");;;;;;;;;;;;;
                str.add("34141014");x
                str.add("266848335");;;;;;;;;;;;;;
                str.add("172878088");x
        str.add("63474985");
*/

        /*str.add("65855063");
        str.add("131372001");
                str.add("145585556");;;;;;;;;;;;;;;
                str.add("280600340");x
        str.add("119817832");
*/

        /*str.add("120211157");
                str.add("142652480");;;;;;;;;;; 1.0
                str.add("136228547");;;;;;;;;;; 0.5
        str.add("138554865");
        str.add("136868068");*/


        /*str.add("139893181");
        str.add("275060162");
        str.add("153486823");
        str.add("158630467");
                str.add("149937149"); change*/

/*

        str.add("136854624");
        str.add("172443128");
        str.add("195693227");
                str.add("195319178"); change
                str.add("153087853");;;;;;;;;;;;;;; 0.5
*/

        /*str.add("162238575");
                str.add("161626703");;;;;;;;;;;;;;;;;;8.0
                str.add("158144179");;;;;;;;;;;;;;;;;0.5
                str.add("240508738");;;;;;;;;;;;;;;0.7
                str.add("101032104");x
*/

                //str.add("166322835");;;;;;;;;;;;;;;;;;//0.6
                //str.add("170570768");x//
                //str.add("185453090");;;;;;;;;;;;;;;;0.2
                //str.add("172654608");;;;;;;;;;;;;;;;//0.2
        //str.add("166319292");

                //str.add("167361138");//xx
                //str.add("233878905");;;;;;;;;;;;;;;;;;0.3
                //str.add("170204972");;;;;;;;;;;;;;0.8
                //str.add("260129689");;;;;;;;;;;;;;;;;;;3.0
        //str.add("178873636");

                //str.add("182577440");;;;;;;;;;;;;;;0.3
                //str.add("270245202");//xx
        //str.add("216334022");
                //str.add("58579043");//xx
                //str.add("200433032");;;;;;;;;;;;;;;;2.0

        //str.add("253790478");
        //str.add("225322958");
                //str.add("179905445");;;;;;;;;;;;;;;;//0.3
        //str.add("275060162");
        //str.add("276462913");

        //str.add("191227859");
        //str.add("213033942");
                //str.add("186512454");;;;;;;;;;;;;;;//0.5
                //str.add("187105903");;;;;;;;;;;;;;;//0.2
                //str.add("229979933");;;;;;;;;;;;;;;//0.2

        //str.add("187105905");
                //str.add("240505756");;;;;;;;;;;;//0.5
                //str.add("197969548");;;;;;;;;;;;//0.2
        //str.add("173021003");

        //str.add("43674688");
                //str.add("143668664");;;;;;;;;;;;;;//0.2
        //str.add("176224697");
        //str.add("165257383");
                //str.add("185670796");;;;;;;;;;;;;;//0.2

        //str.add("189625054");
        //str.add("199343951");
                //str.add("217756012");;;;;;;;;;;;;;//0.5
                //str.add("183160001");;;;;;;;;;;;;;//0.2
                //str.add("194830960");;;;;;;;;;;;;;//0.3

        //str.add("171481547");
                //str.add("224248038");//x
                //str.add("49681445");//x
        //str.add("269249994");
                //str.add("273967801");;;;;;;;;;;;;;//0.2

        //str.add("262313583");
                //str.add("241712757");;;;;;;;;;;;;;//9.0 //236636678
        //str.add("250116919");
                //str.add("209182375");;;;;;;;;;;;;;//0.3
                //str.add("258293686");;;;;;;;;;;;;;//0.3

                //str.add("214392026");;;;;;;;;;;;;;//0.5
        //str.add("257042939");
        //str.add("236933982");
                //str.add("242687226");//////변경/0.3//249334647
        //str.add("235874075");

        //str.add("272882222");
        //str.add("186156381");
                //str.add("279990794");;;;;;;;;;;;;;//1.0
        //str.add("221314050");
                //str.add("238498937");//x

                //str.add("260462650");/////리소스 구림
                //str.add("259853694");//x
        //str.add("219815915");
        //str.add("241383626");
        //str.add("262931274");

        //str.add("284638850");
                //str.add("160194955");;;;;;;;;;;;;;;;//5.0
        //str.add("140475336");
        //str.add("231916889");
                //str.add("220960845");;;;;;;;;;;;;;;//0.5

                //str.add("140807908");;;;;;;;;;;;;;;;//0.3
        //str.add("242225868");
        //str.add("203293939");
        //str.add("206975376");
        //str.add("253510849");

        //str.add("4728569");
                //str.add("245987474");;;;;;;;;;;;;;;;//1.7
        //str.add("277329624");
                //str.add("277211235");//x 안나옴
        //str.add("272761549");

        /*str.add("277356685");
        str.add("272151027");
        str.add("271857932");
        str.add("281924779");
        str.add("276282724");
*/
        //str.add("269941788");
        /*str.add("279382749");
        str.add("270822133");
        str.add("265968680");
        str.add("272855029");
*/
                //str.add("255920980");//x 안나옴
                //str.add("277822085");//x 안나옴
        //str.add("277101066");
        //str.add("263067906");
                //str.add("261756869");;;;;;;;;;;//0.3

                //str.add("253776946");//x 안나옴
        //str.add("269675475");
        //str.add("269673101");
                //str.add("269849077");;;;;;;;;;;;;;;//3.0
                //str.add("273016938");//x 안나옴


        //str.add("271515926");

        //str.add("273903416");

        //str.add("281955932");

        //str.add("282112872");
        //str.add("281781249");

        //str.add("281836704");
        //str.add("281705078");
                //str.add("161193682");;;;;;;;;;;;//0.3
        //str.add("272928535");
        //str.add("237263936");
        //str.add("277528712");
        //str.add("273829672");
        //str.add("259175536");
                //str.add("195462981");;;;;;;;;;//1.6
        //str.add("209054080");
        //str.add("280179314");
        //str.add("272943397");

        //str.add("229279020");
                //str.add("206216712");;;;;;;;;;//0.5
                //str.add("234156073");;;;;;;;;;//0.3
                //str.add("277857001");;;;;;;;;;//1.0
        //str.add("256675794");
                //str.add("242282092");;;;;;;;;;//1.0
        //str.add("213641336");
        //str.add("223899332");
                //str.add("248643262");;;;;;;;;;//10.0
        //str.add("258424328");
        //str.add("277855839");

        //str.add("223535655");
        //str.add("88793245");
                //str.add("211316839");//다른곡으로바꿔야댐

        //str.add("274537370");
        //str.add("280180616");
        //str.add("262418654");
                //str.add("235330583");;;;;;;;;;;//0.3
                //str.add("217880024");;;;;;;;;;;//1.0

        //str.add("277858769");
        //str.add("176232868");

        //str.add("269418301");
        //str.add("281244100");

        //str.add("217755600");
                //str.add("277866516");;;;;;;;;;;;;//0.5
        //str.add("160621101");
        //str.add("276653466");
        //str.add("275453959");
        //str.add("152613151");
        //str.add("252527497");
        //str.add("273468998");
        //str.add("207835651");
        //str.add("274942305");
                //str.add("87175498");;;;;;;;;;;;;//1.0
        //str.add("35188705");









        //str.add("272517395");		timeArray.add(400);
        //str.add("114819921");		timeArray.add(400);

        //str.add("172878088");		timeArray.add(1000);



        //str.add("145585556");		timeArray.add(1000);



        //str.add("142652480");		timeArray.add(1000);
        //str.add("136228547");		timeArray.add(500);











        //str.add("153087853");		timeArray.add(300);

        //str.add("158144179");		timeArray.add(3000);
        //str.add("240508738");		timeArray.add(1000);

        //str.add("161626703");		timeArray.add(10500);
        //str.add("166322835");		timeArray.add(600);

        //str.add("185453090");		timeArray.add(200);
        //str.add("172654608");		timeArray.add(700);


        //str.add("233878905");		timeArray.add(300);
        //str.add("170204972");		timeArray.add(1000);
        //str.add("260129689");		timeArray.add(4500);

        //str.add("182577440");		timeArray.add(300);



        //str.add("200433032");		timeArray.add(2000);


        //str.add("179905445");		timeArray.add(300);




        //str.add("186512454");		timeArray.add(500);
        //str.add("187105903");		timeArray.add(200);
        //str.add("229979933");		timeArray.add(200);

        //str.add("240505756");		timeArray.add(500);
        //str.add("197969548");		timeArray.add(200);


        //str.add("143668664");		timeArray.add(200);

        //str.add("185670796");		timeArray.add(200);


        //str.add("217756012");		timeArray.add(700);
        //str.add("183160001");		timeArray.add(200);
        //str.add("194830960");		timeArray.add(400);




        //str.add("273967801");		timeArray.add(200);

        //str.add("241712757");		timeArray.add(8500);
        //str.add("250116919");		timeArray.add(200);
        //str.add("209182375");		timeArray.add(300);
        //str.add("258293686");		timeArray.add(300);
        //str.add("214392026");		timeArray.add(700);


        //str.add("242687226");		timeArray.add(500);



        //str.add("279990794");		timeArray.add(1000);








        //str.add("160194955");		timeArray.add(5000);


        //str.add("220960845");		timeArray.add(500);
        //str.add("140807908");		timeArray.add(300);





        //str.add("245987474");		timeArray.add(1600);
















        //str.add("261756869");		timeArray.add(300);



        //str.add("269849077");		timeArray.add(3000);


















        //str.add("195462981");		timeArray.add(1800);





        //str.add("206216712");		timeArray.add(500);
        //str.add("234156073");		timeArray.add(300);
        //str.add("277857001");		timeArray.add(1000);

        //str.add("242282092");		timeArray.add(1000);


        //str.add("248643262");		timeArray.add(9500);

        /*str.add("235330583");		timeArray.add(300);
        str.add("217880024");		timeArray.add(1000);

        str.add("277866516");		timeArray.add(500);
        str.add("87175498");		timeArray.add(1000);

        str.add("161193682");		timeArray.add(1500);*/

        //str.add("280196726");		timeArray.add(300);
        //str.add("178707996");		timeArray.add(5000);





        //str.add("131608051");		timeArray.add(0);










        //str.add("280180616");		timeArray.add(182000);

        //str.add("186521825");		timeArray.add(0);



        //str.add("160904637");		timeArray.add(0);





        //str.add("239360419");		timeArray.add(0);

                //str.add("58579043");		timeArray.add(0); // 짤림


























        //str.add("196782562");		timeArray.add(0);
        //str.add("51542437");		timeArray.add(0);






        //str.add("233561916");		timeArray.add(24800);
        //str.add("269249553");		timeArray.add(213700);





























        //str.add("284589875");		timeArray.add(0);
        //str.add("277822379");		timeArray.add(0);

        //str.add("273969251");		timeArray.add(1200);



        //str.add("276803179");		timeArray.add(1000);

        //str.add("277666063");		timeArray.add(0);

        //str.add("281501673");		timeArray.add(300);

        //str.add("281495829");		timeArray.add(0);














        //str.add("182395671");		timeArray.add(0);


        //str.add("282933010");		timeArray.add(0);


        //str.add("220951088");		timeArray.add(600);
        //str.add("283507245");		timeArray.add(0);


        //str.add("280172336");		timeArray.add(0);


                //str.add("205613294");		timeArray.add(0); // 바꿔야함


        //str.add("281696106");		timeArray.add(300);


        //str.add("143996884");		timeArray.add(1200);
        //str.add("273968389");		timeArray.add(5000);
        //str.add("236751678");		timeArray.add(500);
        //str.add("162735797");		timeArray.add(2000);

        //str.add("185397996");		timeArray.add(4000);

        //str.add("37328731");		timeArray.add(400);
        //str.add("35697730");		timeArray.add(400);
        //str.add("163698369");		timeArray.add(100);
        //str.add("228296592");		timeArray.add(800);
        //str.add("270052873");		timeArray.add(15000);
        //str.add("41208902");		timeArray.add(0);

        //str.add("226542459");		timeArray.add(300);


        final String CLIENT_ID = "59eb0488cc28a2c558ecbf47ed19f787";
        prepareMusic(CLIENT_ID);
    }

    public void musicPlay(final int trackNum, int duration) {
        // time ms만큼 음악 재생, time = -1일 경우 계속 재생

        Log.e("trackId", titleArray.get(trackNum) + " / " + playerArray.get(trackNum).getCurrentPosition());

        // 이걸로 재생 시간 조절
        //playerArray.get(trackNum).seekTo(0);
        playerArray.get(trackNum).seekTo(time.get(trackNum));
        playerArray.get(trackNum).start();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() { // time ms 후 음악 정지
            @Override
            public void run() {
                playerArray.get(trackNum).pause();
                //playerArray.get(trackNum).seekTo(0);
                playerArray.get(trackNum).seekTo(time.get(trackNum));
            }
        }, duration);
    }

    void prepareMusic(String CLIENT_ID) {
        String soundUrl = null;
        //MediaPlayer mediaPlayer = null;
        for(int i=0; i<str.size(); i++) {
            soundUrl = "https://api.soundcloud.com/tracks/" + str.get(i) + "/stream?client_id=" + CLIENT_ID;

            final MediaPlayer mediaPlayer = new MediaPlayer();

            Log.e("tic log", "prepare success / soundNum : " + str.get(i) + " / Time : " + mediaPlayer.getAudioSessionId());

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            try {
                mediaPlayer.setDataSource(soundUrl);

                // 2곡은 sync로 prepare() 에서 준비시키고
                if(i<5) {
                    mediaPlayer.prepare(); // might take long! (for buffering, etc)

                    playerArray.add(mediaPlayer);
                    titleArray.add(str.get(i));
                    time.add(timeArray.get(i));


                } else {
                    // 나머지 3곡은 async 로 불러옴
                    asyncPrepare(i, mediaPlayer);
                    /*mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            playerArray.add(mediaPlayer);
                        }
                    });
                    mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(){
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            Log.e("prepareAsync Error", "error!!");
                            i--;
                            return false;
                        }
                    });*/
                    mediaPlayer.prepareAsync(); // prepareAsync() 는 순서상 가장 나중에 불려야함.
                }
            } catch (Exception e) {
                Log.e("prepare Error", str.get(i) + " / Error!!");
                e.printStackTrace();
            }
        }
    }

    private void asyncPrepare(final int i, MediaPlayer media) {

        final MediaPlayer mediaPlayer = media;
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp) {
                playerArray.add(mediaPlayer);
                titleArray.add(str.get(i));
                time.add(timeArray.get(i));
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener(){

            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.e("prepareAsync Error", "error!!");

                return false;
            }
        });

    }

    @OnClick(R.id.play)
    void play() {
        musicPlay(playNum, 1550);
    }
    @OnClick(R.id.previous)
    void prev() {
        playNum--;
        musicPlay(playNum, 1550);
    }
    @OnClick(R.id.next)
    void next() {
        playNum++;
        musicPlay(playNum, 1550);
    }
    @OnClick(R.id.three)
    void three() {
        musicPlay(playNum, 3000);
    }
    @OnClick(R.id.longg)
    void longg() {
        musicPlay(playNum, 20000);
    }

}

//    public class quizSettingHandler implements Runnable {
//        public void run () {
//            // 문제 준비 및 유저 정보 받아오기
//            for (int i = 0; i < MAX_QUIZ_NUM; i++) { // 문제와 답 정해진 개수만큼 설정
//                //boolean isNumUsed = false; // 번호 중복 확인 여부
//
//                final String CLIENT_ID = "59eb0488cc28a2c558ecbf47ed19f787";
//                //int soundNum = 1 + (int) (Math.random() * MAX_TRACK_COUNT);
//
//                String[] track_data = getResources().getStringArray(getResources().getIdentifier("track" + i, "array", MainActivity.this.getPackageName()));
//
//                String track_id = track_data[0];
//
//                String soundUrl = "https://api.soundcloud.com/tracks/" + track_id + "/stream?client_id=" + CLIENT_ID;
//
//                for (int j = 0; j < i; j++) {
//                    if (soundUrl.equals(addressArray.get(j))) {
//                        // 문제 중복
//                        isNumUsed = true;
//                    }
//                }
//
//                if (isNumUsed) { // 문제 중복 시 다시 받아오게 함
//                    Log.i("ticlog", "quizNum reset");
//                    i—;
//                } else {
//                    addressArray.add(soundUrl);
//
//                    answerArray.add(track_data[1]);
//                    artistArray.add(track_data[2]);
//                    timeArray.add(Integer.parseInt(track_data[3]));
//                    playerArray.add(new MediaPlayer());
//                    playerArray.get(i).setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    try {
//                        playerArray.get(i).setDataSource(addressArray.get(i));
//                        try {
//                            playerArray.get(i).prepare();
//                            playerArray.get(i).seekTo(timeArray.get(i));
//                            //prepare 하는데 시간이 많이 걸림
//                            Log.i("tic log", "prepare success / soundNum : " + soundNum + " / Time : " + playerArray.get(i).getDuration());
//                        } catch (Exception e) { // prepare가 안되면 삭제된 파일이므로 이번 Array를 삭제하고 다시 받아오게 함
//                            e.printStackTrace();
//                            Log.i("tic log", "prepare catch, removed trackNum : " + soundNum);
//                            answerArray.remove(i);
//                            artistArray.remove(i);
//                            addressArray.remove(i);
//                            timeArray.remove(i);
//                            playerArray.remove(i);
//                            i—;
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        Log.i("tic log", "setDataSource catch, removed trackNum : " + soundNum);
//                        answerArray.remove(i);
//                        artistArray.remove(i);
//                        addressArray.remove(i);
//                        timeArray.remove(i);
//                        playerArray.remove(i);
//                        i—;
//                    }
//                }
//            }
//
//        }
//    }
//}