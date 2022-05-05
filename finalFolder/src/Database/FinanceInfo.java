import java.time.LocalDate;
import java.util.Date;

public class FinanceInfo {


    private String Month;
	private String Day;
	private String Year;
	private String ProfitMonth;
	private String ProfitDay;
	private String ProfitYear;
	private String PopularItemM;
	private String PopularItemY;
	private String PopularItemD;
	private String Profit;
	private String orderproductId;
	private Date date;
	

	public FinanceInfo ( String Month, String Year, String Profit, String PopularItemM, String orderproductId)
    
	
	{	
    super();
    this.Month = Month;
	//this.Day = Day;
	this.Year = Year;
	this.Profit = Profit;
	//this.ProfitMonth = ProfitMonth;
	//this.ProfitDay = ProfitDay;
	//this.ProfitYear = ProfitYear;
	this.PopularItemM = PopularItemM;
	//this.PopularItemD = PopularItemD;
	//this.PopularItemY = PopularItemY;
	//this.date = date;
	this.orderproductId = orderproductId;
    }
    



	public String getMonth() {
        return Month;
    }
    public void setMonth(String Month) {
        this.Month = Month;
    }
   
    public String getDay() {
        return Month;
    }
    public void setDay(String Day) {
        this.Day = Day;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String Year) {
        this.Year = Year;
    }
    public String getProfit() {
        return Profit;
    }
    public void setProfit(String Profit) {
        this.Profit = Profit;
    }
    
	public String getProfitMonth() {
        return Month;
    }
    public void setProfitMonth(String ProfitMonth) {
        this.ProfitMonth = ProfitMonth;
    }
   
    public String getProfitDay() {
        return Month;
    }
    public void setProfitDay(String ProfitDay) {
        this.ProfitDay = ProfitDay;
    }
    public String getProfitYear() {
        return Year;
    }
    public void setProfitYear(String ProfitYear) {
        this.ProfitYear = ProfitYear;
    }
    public String getPopularItemM() {
        return PopularItemM;
    }
    public void setPopularItemM(String PopularItemM) {
        this.PopularItemM = PopularItemM;
    }
   
    public String getPopularItemD() {
        return PopularItemD;
    }
    public void setPopularItemD(String PopularItemD) {
        this.PopularItemD = PopularItemD;
    }
    public String getPopularItemY() {
        return PopularItemY;
    }
    public void setPopularItemYear(String PopularItemY) {
        this.PopularItemY = PopularItemY;
    }
    
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
   
    public String getOrderproductId() {
        return orderproductId;
    }
    public void setorderproductId(String orderproductId) {
        this.orderproductId = orderproductId;
   }
    
 
  //toString()
    @Override
    public String toString() {
       // return "OderInfo [ Day = " + Day +", Month = " +Month +", Year = "+ Year +",  Daily profits =" + ProfitDay + ", monthly profits =" 
        //		+ ProfitMonth + ",Yearly profits="+ ProfitYear +" Day Popular Item =" + PopularItemD +", "
        	//	+ "Month Popular Item =" + PopularItemM +", Year Popular Item =" + PopularItemY +"]";
   
    	return "FinanceInfo [  Month = " +Month +", Year = "+ Year +",  Profits =" + Profit +"  Popular =" +  PopularItemM+ "Product_Id = "+orderproductId + "]";
    } 
    
    
}