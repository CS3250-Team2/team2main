import java.util.List;

import javax.swing.table.AbstractTableModel;

public class FinanceTableModel extends AbstractTableModel  {
	
	private static final long serialVersionUID = -715697162861296537L;
	public final int OBJECT_COL = -1;
	private static final int month_col = 0;
	private static final int year_col = 1;
	private static final int profit_col = 2;
	private static final int item_col =3;
	
	
	private String[] columnNames = { "Month", "Year", "Profit", "Popular Item"};
	private List<FinanceInfo> FinanceInfo;
	
	public FinanceTableModel(List<FinanceInfo> theFinanceinfo) {
		FinanceInfo = theFinanceinfo;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return FinanceInfo.size();
		}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		FinanceInfo tempFinanceInfo = FinanceInfo.get(row);
		switch (col)
			{
			case month_col :
				return tempFinanceInfo.getMonth();
			case year_col :
				return tempFinanceInfo.getYear();
			case profit_col:
				return tempFinanceInfo.getProfit();
			default  :
				
				return  tempFinanceInfo.getPopularItemM();
				
			
			}
		
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}