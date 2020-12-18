package info.budget.budgettracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

public abstract class BudgetTrackerSearchLogic {
	// private String yearMonth;
	private String id;
	private String date;
	private String storeName;
	private String productName;
	private String type;
	private String price;

	// DB�֘A�̏����ݒ�
	protected DataSource ds = null;
	ResultSet rset = null;

	// �R���X�g���N�^
	public BudgetTrackerSearchLogic(HttpServletRequest request, DataSource ds) {

		setId(request.getParameter("id"));
		setDate(request.getParameter("date"));
		setStoreName(request.getParameter("storeName"));
		setProductName(request.getParameter("productName"));
		setType(request.getParameter("type"));
		setPrice(request.getParameter("price"));
		this.ds = ds;
	}

	// �f�[�^�x�[�X�ւ̃A�N�V����
	// �f�[�^�̒ǉ������{
	public ResultSet searchData() throws Exception {

		Connection conn = ds.getConnection();
		String tableNm = getTableName();
		StringBuilder sql = new StringBuilder();

		// sql����\��
		sql.append("select id, Date, StoreName, ProductName, type, Price from " + tableNm + " where StoreName like '%'");
		//sql.append(storeName + "%'");
		System.out.println(sql);

		// if id is selected, add it
		if (id != "") {
			sql.append("and id ='" + this.getId() + "';");
		}

		// if Date is selected, add it
		if (date != "") {
			sql.append("and Date ='" + date + "'");
		}

		// if StoreName is selected, add it
		if (storeName != "") {
			sql.append("and StoreName ='" + storeName + "'");
		}

		// if ProductName is selected, add it
		if (productName != "") {
			sql.append("and ProductName ='" + productName + "'");
		}

		// if Type is selected, add it
		if (type != "") {
			sql.append("and Type ='" + type + "'");
		}

		// if Price is selected, add it
		if (type != "") {
			sql.append("and Price ='" + price + "'");
		}

		PreparedStatement pstmt = conn.prepareStatement(new String(sql));
		

		// sql�����s
		boolean res = pstmt.execute();
		rset = pstmt.executeQuery();
		
		ServletRequest request = null;
		request.setAttribute("SqlResult", rset);
		
		return rset;

		// �g�p�����I�u�W�F�N�g���I��������
		//pstmt.close();
		// conn.close(); Web�T�[�o�[���̃R�l�N�V�������g���Ă��邽�߃R�l�N�V�����̓N���[�Y���Ȃ�
		

		//return res;
	}

	// �T�u�N���X����e�[�u������Ԃ�
	protected abstract String getTableName();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}
}