import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DetailFinanceTableModel extends AbstractTableModel  {
	
	private static final long serialVersionUID = -715697162861296537L;
	public final int OBJECT_COL = -1;
	private static final int productId_col = 0;
	private static final int profit_col = 1;
	
	
	private String[] columnNames = { "Product ID", "Profit"};
	
	private List<FinanceInfo> orderInfo;
	
	public DetailFinanceTableModel(List<FinanceInfo> theOrderinfo) {
		orderInfo = theOrderinfo;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return orderInfo.size();
		}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		FinanceInfo tempOrderInfo = orderInfo.get(row);
		switch (col)
			{
		
			case productId_col :
				return tempOrderInfo.getOrderproductId();
			default  :
				return tempOrderInfo.getProfit();
			
			}
		
	}
	
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}	