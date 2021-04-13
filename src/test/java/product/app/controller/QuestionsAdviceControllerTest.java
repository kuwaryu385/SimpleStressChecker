package product.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import product.app.service.QuestionsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")

public class QuestionsAdviceControllerTest {

	private MockMvc mockMvc;

	// モック化するクラスのインスタンスを生成
	@MockBean
	private QuestionsService service;

	// モックを注入するクラスのインスタンスを生成、DIコンテナに登録
	@Autowired
	private QuestionsAdviceController target;

	//ここで初期設定。Test用に設定。mockMvcインスタンスを利用して、仮想のリクエストを発生させテストを実行します。
	@Before
	public void setUp() throws Exception {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("classpath:templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(target).setViewResolvers(viewResolver).build();
	}

	@Test
	public void アドバイスページのリクエスト結果が正常となりViewとしてadviceが返る事() throws Exception {
		//レスポンスのHTTPステータスコードは正しいか？
		mockMvc.perform(get("/sqtop/advice")).andDo(print())
				.andExpect(status().isOk())//ステータスコード200はstatus().isOkでテスト
				.andExpect(view().name("advice"));//指定のviewで返すか（”/”でtop.htmlを返すか確認する）
	}

}
