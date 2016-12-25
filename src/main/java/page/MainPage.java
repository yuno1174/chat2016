package page;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import bean.AccountBean;
import bean.MessageBean;
import common.ChatCommonPage;

public class MainPage extends ChatCommonPage {
	private static final long serialVersionUID = 1L;

	public MainPage() {
		super();

		IModel<List<MessageBean>> messageListModel = new ListModel<MessageBean>(getMessage());


		final WebMarkupContainer messageComponent = new WebMarkupContainer("messageComponent"){
			@Override
			protected void onInitialize() {
				super.onInitialize();
				setOutputMarkupId(true);
			}
		};

		ListView<MessageBean> messageListView = new ListView<MessageBean>("messageList", messageListModel) {

			@Override
			protected void populateItem(ListItem<MessageBean> item) {
				item.add(new Label("message", item.getModelObject().getMessage()));
				item.add(new Label("accountName", item.getModelObject().getAccountBean().getName()));
				item.add(new Label("postTime", item.getModelObject().getPostTime()));
			}
		};

		AjaxLink<Void> messageReloadLink = new AjaxLink<Void>("messageReloadLink"){

			@Override
			public void onClick(AjaxRequestTarget target) {
				target.add(messageComponent);
			}
		};

		messageComponent.add(messageReloadLink);
		messageComponent.add(messageListView);

		this.add(messageComponent);

    }
	private List<MessageBean> getMessage(){

		List<MessageBean> list = new ArrayList<MessageBean>();
		list.add(new MessageBean(1,"ガルパンはいいぞぉ",
				new AccountBean(1,"ガルパンおじさん",null,false)
				,Date.valueOf("2016-12-24")));
		list.add(new MessageBean(2,"やったぜ",
				new AccountBean(2,"変態糞土方",null,false)
				,Date.valueOf("2016-12-25")));

		return list;
	}
}