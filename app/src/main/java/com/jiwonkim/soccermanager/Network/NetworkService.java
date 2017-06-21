package com.jiwonkim.soccermanager.Network;

import com.jiwonkim.soccermanager.Main.Login.LoginData;
import com.jiwonkim.soccermanager.Main.Login.LoginResult;
import com.jiwonkim.soccermanager.Main.Login.UserData;
import com.jiwonkim.soccermanager.Main.Mypage.ModifyResult;
import com.jiwonkim.soccermanager.Main.Regist.MemberData;
import com.jiwonkim.soccermanager.Main.Regist.RegistResult;
import com.jiwonkim.soccermanager.Main.Search.SearchUserResult;
import com.jiwonkim.soccermanager.Main.TeamPage.TeamManage.TeamInfo;
import com.jiwonkim.soccermanager.Main.TeamPage.TeamManage.TeamCreateResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by user on 2017-06-12.
 */

public interface NetworkService {
    // 로그인
    @POST("member/login")
    Call<LoginResult> getLoginResult(@Body LoginData loginData);
    // Call<서버에서 받을 정보를 담은 클래스> 호출할 메소드이름 (@Body 바디에 담아서 보낼 객체)

    // 회원가입
    @POST("member/register")
    Call<RegistResult> getRegistResult(@Body MemberData memberData);

    // 회원정보 수정
    @POST("member/modify/{id}")
    Call<ModifyResult> getModifyResult(@Path("id") String id, @Body UserData userData);

    // 유저 검색
    @GET("member/findUser/{id}")
    Call<SearchUserResult> getSearchUserResult(@Path("id") String id);

    // 구단 생성
    @POST("team/create")
    Call<TeamCreateResult> getTeamCreateResult(@Body TeamInfo teamInfo);
}
