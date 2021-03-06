package com.mychat2016;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;

import bean.Account;
import common.ChatCommonPage;
import common.MySession;
import page.MainPage;
import service.AccountService;
import service.IAccountService;


public class HomePage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		super();

		final TextField<String> nameText = new TextField<String>("name",new Model<String>(""));
		final PasswordTextField passwordText = new PasswordTextField("password",new Model<String>(""));

		nameText.setRequired(true);
		passwordText.setRequired(true);

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = 1L;
		};

		Button submitButton = new Button("submit"){
			@Override
			public void onSubmit() {
				super.onSubmit();

				IAccountService accountService = new AccountService();

				System.out.println("name:"+nameText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());

				if(nameText.getModelObject() == null
						|| passwordText.getModelObject() == null){
					System.out.println("アカウントとパスワードを入力してください");
				}else{


					Account account = accountService.select(
								nameText.getModelObject(),
								passwordText.getModelObject());

					// アカウントなかったらIDが0のインスタンスが生成される
					if(account.getId() > 0){
						MySession.get().setAccountBean(account);
						MySession.get().setLoggedIn(true);
						setResponsePage(new MainPage());
					}else{
						error("アカウントが存在しないか、パスワードが間違っています");
					}

				}
			}

			@Override
			public void onError() {
				super.onError();

				System.out.println("error");

				System.out.println("id:"+nameText.getModelObject());
				System.out.println("pass:"+passwordText.getModelObject());

			}
		};

		form.add(nameText);
		form.add(passwordText);
		form.add(submitButton);
		this.add(form);
		form.add(new FeedbackPanel("feedback"));
    }
}
