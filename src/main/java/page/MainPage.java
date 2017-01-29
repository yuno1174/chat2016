package page;

import java.sql.Timestamp;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import bean.Message;
import common.ChatCommonPage;
import common.MySession;
import service.MessageService;

public class MainPage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;


	public MainPage() {
		super();

		final MessageService messageService = new MessageService();

		final IModel<List<Message>> messageListModel =
				new ListModel<Message>(messageService.select());


		final WebMarkupContainer messageContainer = new WebMarkupContainer("messageContainer"){

			private static final long serialVersionUID = 1L;

			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}
		};

		final ListView<Message> messageListView = new ListView<Message>("messageList", messageListModel) {

			@Override
			protected void populateItem(ListItem<Message> item) {
				item.add(new Label("message", item.getModelObject().getMessage()));
				item.add(new Label("accountName", item.getModelObject().getAccountBean().getName()));
				item.add(new Label("postTime", item.getModelObject().getPostTime()));
			}

			@Override
			protected void onInitialize() {
				super.onInitialize();

				setOutputMarkupId(true);
			}
		};

		AjaxLink<Void> messageReloadLink = new AjaxLink<Void>("messageReloadLink"){

			@Override
			public void onClick(AjaxRequestTarget target) {
				messageListModel.setObject(messageService.select());

				target.add(messageContainer);
			}
		};

		final IModel<String> textModel = new Model<String>("");

		TextField<String> text = new TextField<>("text", textModel);


		Form<Void> form = new Form<Void>("form");

		AjaxButton submit = new AjaxButton("submit") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);

				Message message = new Message();
				message.setMessage(textModel.getObject());
				message.setAccountBean(MySession.get().getAccountBean());
				message.setPostTime(new Timestamp(System.currentTimeMillis()));

				if(messageService.insert(message)>0){
					// 成功
				}else{
					// 失敗
				}

				textModel.setObject("");

				messageListModel.setObject(messageService.select());

				target.add(messageContainer);
			}
		};



		messageContainer.add(messageListView);

		form.add(text);
		form.add(submit);

		this.add(messageReloadLink);
		this.add(messageContainer);
		this.add(form);

    }
}