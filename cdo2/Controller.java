import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

import java.lang.*;
import java.lang.reflect.*;
import java.util.StringTokenizer;
import java.io.*;



class CDO
  implements SystemTypes
{
  private double ps0 = 0; // internal
  private double variance = 0; // internal
  private List sectors = new Vector(); // of Sector
  private List borrowers = new Vector();
  private List distributeTable = new Vector();
 

  public CDO()
  {
    this.ps0 = 0;
    this.variance = 0;
  }

  public String toString()
  { String _res_ = "(CDO) ";
    _res_ = _res_ + ps0;
    return _res_;
  }

  public void setps0(double ps0_x) { ps0 = ps0_x;  }

  
  

  public static void setAllps0(List cdos,double val)
{ for (int i = 0; i < cdos.size(); i++)
    { CDO cdox = (CDO) cdos.get(i);
      Controller.inst().setps0(cdox,val); } }


  public void setsectors(List sectorsxx) { sectors = sectorsxx;
    }
 
  public void setsectors(int ind_x,Sector sectorsxx) { sectors.set(ind_x,sectorsxx); }

 public void addsectors(Sector sectorsxx) { sectors.add(sectorsxx);
    }
 
  public void removesectors(Sector sectorsxx) { Vector _removedsectorssectorsxx = new Vector();
  _removedsectorssectorsxx.add(sectorsxx);
  sectors.removeAll(_removedsectorssectorsxx);
    }

  public static void setAllsectors(List cdos,List _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().setsectors(cdox, _val); } }

  public static void setAllsectors(List cdos,int _ind,Sector _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().setsectors(cdox,_ind,_val); } }

  public static void addAllsectors(List cdos,Sector _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().addsectors(cdox, _val); } }


  public static void removeAllsectors(List cdos,Sector _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().removesectors(cdox, _val); } }


  public static void unionAllsectors(List cdos, List _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().unionsectors(cdox, _val); } }


  public static void subtractAllsectors(List cdos, List _val)
  { for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      Controller.inst().subtractsectors(cdox, _val); } }
  


  
  public double getps0() { return ps0; }

  public static List getAllps0(List cdos)
  { List result = new Vector();
    for (int i = 0; i < cdos.size(); i++)
    { CDO cdox = (CDO) cdos.get(i);
      if (result.contains(new Double(cdox.getps0()))) { }
      else { result.add(new Double(cdox.getps0())); } }
    return result; }

  public static List getAllOrderedps0(List cdos)
  { List result = new Vector();
    for (int i = 0; i < cdos.size(); i++)
    { CDO cdox = (CDO) cdos.get(i);
      result.add(new Double(cdox.getps0())); } 
    return result; }

  

  
  
  
  
  public List getsectors() { return (Vector) ((Vector) sectors).clone(); }

  public static List getAllsectors(List cdos)
  { List result = new Vector();
    for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      result = Set.union(result,cdox.getsectors()); }
    return result; }

  public static List getAllOrderedsectors(List cdos)
  { List result = new Vector();
    for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox = (CDO) cdos.get(_i);
      result.addAll(cdox.getsectors()); }
    return result; }
  
  
//*************************************************************************************************************************  
  

  //set variance
  public void setvariance(double sigma_x) { variance = sigma_x;  }
  
  //set variance (calculate)
  public void setvariance() 
  {
	  double result;
	  result = Set.sumdouble(Set.collect_7(Set.integerSubrange(1,sectors.size()),this));
	  this.setvariance(result);
  }
  
  //set all variance 
  			//public static void setAllvariance(List cdos,double val)
  				//add an function setvariance in controller 
	  
  
  //set all variance (calculate)
  
  
  //set borrowers 
  public void setborrowers(List borrowersxx) { borrowers = borrowersxx;}
  
  //set borrowers 
  public void setborrowers(int ind_x,Borrower borrowersxx) { borrowers.set(ind_x,borrowersxx); }
	
  //add borrowers
  public void addborrowers(Borrower borrowersxx) { borrowers.add(borrowersxx);}
  
  //removesectors
  public void removeborrowers(Borrower borrowersxx) { Vector _removedborrowersxx = new Vector();
  _removedborrowersxx.add(borrowersxx);
  borrowers.removeAll(_removedborrowersxx);
    }
  
  //setAllborrowers
  
  //setAllborrowers
  
  //addAllborrowers
  
  //removeAllborrowers
  
  //unionAllborrowers
  
  //subtractAllborrowers
  
  
  
  //set distribute table 
  public void setdistributeTable(List distributeTablexx) { distributeTable = distributeTablexx;}
  
  
  //set distribute table 
  public void setdistributeTable(int ind_x,BorrowerInSector distributeTablexx) { distributeTable.set(ind_x,distributeTablexx); }
  
  
  //add distribute table 
  public void adddistributeTable(BorrowerInSector distributeTablexx) { distributeTable.add(distributeTablexx);}
  
  
  //remove distribute table 
  public void removedistributeTable(BorrowerInSector distributeTablexx) { Vector _removeddistributeTablexx = new Vector();
  _removeddistributeTablexx.add(distributeTablexx);
  distributeTable.removeAll(_removeddistributeTablexx);
    }
  
  
  //setAll distribute table 
  
  //setAll distribute table 
  
  //addAll distribute table 
  
  //removeAll distribute table 
  
  //unionAll distribute table 
  
  //subtractAll distribute table 
  
  
  
  
  //get variance
  public double getvariance() { return variance; }
  
  //get all variance
  
  
  //get all AllOrdered variance
  
  //get borrowers
  public List getborrowers() { return (Vector) ((Vector) borrowers).clone(); }
  
  
  //get all borrowers
  
  
  //get all Ordered borrowers
  
  
  
  
  //get distribute table 
  public List getdistributeTable() { return (Vector) ((Vector) distributeTable).clone(); }
  
  
  //get all distribute table
  
  //get all Ordered distribute table 
  
  
  //get related borrowers for a single sector based on sectorID (return  list :type : BorrowerInSector)
  public List getBorrowersForSector(int k)
  {   
	List result = new Vector();
    for (int i = 0; i < distributeTable.size(); i++)
    { BorrowerInSector distributex = (BorrowerInSector) distributeTable.get(i);
      if (distributex.getsectorID() == k) {result.add(distributex);}
    }
    return result;
  }
  
  
  //calculate and set p for a single sector
  public void setpforSectors(int k)
  {
	  double result = 0;
	  Sector sectorx = (Sector) sectors.get(k-1);
	  result = Set.sumdouble(Set.collect_5(Set.integerSubrange(1,sectorx.getn()),this,k));
	  sectorx.setp(result);
	  this.setsectors(k-1, sectorx);
  }

  //calculate and set p for all sectors
  public void setpforSectors()
  {
	  for (int _i = 1; _i <= sectors.size(); _i++)
	  {
		  this.setpforSectors(_i);
	  }
  }
  
  //calculate and set p for all sectors for all CDO
  
  
  //calculate and set L for a single sector
  public void setLforSectors(int k)
  {
	  double result = 0;
	  Sector sectorx = (Sector) sectors.get(k-1);
	  result = Set.sumdouble(Set.collect_6(Set.integerSubrange(1,sectorx.getn()),this,k));
	  sectorx.setL(result);
	  this.setsectors(k-1, sectorx);
  }
  
  
  //calculate and set L for all sectors 
  public void setLforSectors()
  {
	  for (int _i = 1; _i <= sectors.size(); _i++)
	  {
		  this.setLforSectors(_i);
	  }
  }
  
  //calculate and set L for all sectors for all CDO
  
  
// calculate varianceComponents for variance
  public double varianceComponents(int k)
  {
	  double result = 0;
	  
	  Sector x = (Sector)this.getsectors().get(k-1);
	  
	  result = Set.sumdouble(Set.collect_8(Set.integerSubrange(1,x.getn()),this,k));
	  
	  return result;
  }
  
//**********************************
  
  //borrower risk contribution (9.31)
    
//**********************************  
  
//**********************************************************************************************************************************
  
  
  //k is the number of sector, calculate the directdefault for a single sector, don't know why write this 
    public double nocontagion(int k,int m)
  {   double result = 0;
  //same as sector.nocontagion : Math.pow(( 1 - p ),n - m) * Math.pow(p,m) * Math.pow(( 1 - q ),m * ( n - m ));
  result = Math.pow(( 1 - ((Sector) sectors.get(k - 1)).getp() ),((Sector) sectors.get(k - 1)).getn() - m) * Math.pow(((Sector) sectors.get(k - 1)).getp(),m) * Math.pow(( 1 - ((Sector) sectors.get(k - 1)).getq() ),m * ( ((Sector) sectors.get(k - 1)).getn() - m ));
    return result;
  }

//k is the number of sector, calculate the P(N = m) for a single sector
    public double P(int k,int m)
  {   double result = 0;
 
  result = StatFunc.comb(((Sector) sectors.get(k - 1)).getn(),m) * ( ((Sector) sectors.get(k - 1)).nocontagion(m) + Set.sumdouble(Set.collect_0(Set.integerSubrange(1,m - 1),this,k,m)) );
    return result;
  }

//calculate P(Nk = mk |Nk > 0) = P(Nk = mk)/muk
    public double PCond(int k,int m)
  {   double result = 0;
 
  if (m >= 1) 
  {   result = this.P(k,m) / ( 1 - Math.pow(( 1 - ((Sector) sectors.get(k - 1)).getp() ),((Sector) sectors.get(k - 1)).getn()) );
 
  }  else   if (m < 1) 
  {   result = 0;
 
  }    return result;
  }

//calculate [s/Lk] for VS
    public int maxfails(int k,double d)
  {   int result = 0;
 
  if (((Sector) sectors.get(k - 1)).getn() <= ( d / ((Sector) sectors.get(k - 1)).getL() )) 
  {   result = ((Sector) sectors.get(k - 1)).getn();
 
  }  else   if (((Sector) sectors.get(k - 1)).getn() > ( d / ((Sector) sectors.get(k - 1)).getL() )) 
  {   result = (int) (d / ((Sector) sectors.get(k - 1)).getL());
 
  }    return result;
  }

//calculate PS, save the result in map PS_cache, easier to get
    public double PS(double d)
  {   double result = 0;
  Object cached_result = PS_cache.get(new Double(d));
  if (cached_result != null)
  { result = ((Double) cached_result).doubleValue(); 
    return result; 
  }
  else 
  {   if (d < 0) 
  {   result = 0;
 
  }  else   if (d == 0) 
  {   result = ps0;
 
  }  else   if (d > 0) 
  {   result = Set.sumdouble(Set.collect_1(Set.integerSubrange(1,sectors.size()),this,d)) / d;
 
  }
    PS_cache.put(new Double(d), new Double(result));
  }
  return result;
 }

//calculate VS, set the range ,use collect_2
    public double VS(int k,double d)
  {   double result = 0;
 
  result = Set.sumdouble(Set.collect_2(Set.integerSubrange(1,this.maxfails(k,d)),this,k,d));
    return result;
  }


    
    
    
//****************************************************************************************************************
    public void test1(Sector s)
  { 
    	Controller.inst().setmu(s,1 - Math.pow(( 1 - s.getp() ),s.getn()));
  }

    public void test1outer()
  {  CDO cdox = this;
     
     //******************
  
  	 // maybe I need to set p and L through Controller like test1
  	 Controller.inst().setpforSectors(this);
  	 Controller.inst().setLforSectors(this);
     
     //*******************
     
     List _range1 = cdox.getsectors();
     for (int _i0 = 0; _i0 < _range1.size(); _i0++)
     { Sector s = (Sector) _range1.get(_i0);
       this.test1(s);
     } 
     
     
  }


    public void test2()
  { 
    	Controller.inst().setps0(this,Math.exp(-Set.sumdouble(Sector.getAllOrderedmu(this.getsectors()))));
  
    	//**************
    	Controller.inst().setvariance(this);
    	//**************
    	
  }

    public void test3()
  {     /*List _integer_list2 = new Vector();
    _integer_list2.addAll(Set.integerSubrange(0,50));
    for (int _ind3 = 0; _ind3 < _integer_list2.size(); _ind3++)
    { int s = ((Integer) _integer_list2.get(_ind3)).intValue();
        System.out.println("" + this.PS(s));

    }*/
    	for (int _ind3 = 0; _ind3 < this.borrowers.size(); _ind3++)
        {  Borrower x = (Borrower) this.getborrowers().get(_ind3);
            System.out.println("" + x.getL() + " and " + x.getp());
        }
    	
    	for (int _ind3 = 0; _ind3 < this.sectors.size(); _ind3++)
        {  Sector x = (Sector) this.getsectors().get(_ind3);
            System.out.println("" + x.getL() + " and " + x.getp());
        }
    	
    	System.out.println("" + this.getvariance());

  }

//***********************************************************************************************************************************
    
  private  java.util.Map PS_cache = new java.util.HashMap();

}


class Sector
  implements SystemTypes
{
  private String name = ""; // internal
  private int n = 0; // internal
  private double p = 0; // internal
  private double q = 0; // internal
  private double L = 0; // internal
  private double mu = 0; // internal

  public Sector()
  {
    this.name = "";
    this.n = 0;
    this.p = 0;
    this.q = 0;
    this.L = 0;
    this.mu = 0;

  }



  public String toString()
  { String _res_ = "(Sector) ";
    _res_ = _res_ + name + ",";
    _res_ = _res_ + n + ",";
    _res_ = _res_ + p + ",";
    _res_ = _res_ + q + ",";
    _res_ = _res_ + L + ",";
    _res_ = _res_ + mu;
    return _res_;
  }

  public void setname(String name_x) { name = name_x;  }


  public static void setAllname(List sectors,String val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setname(sectorx,val); } }


  public void setn(int n_x) { n = n_x;  }


  public static void setAlln(List sectors,int val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setn(sectorx,val); } }


  public void setp(double p_x) { p = p_x;  }


/*  public static void setAllp(List sectors,double val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setp(sectorx,val); } }
*/

  public void setq(double q_x) { q = q_x;  }


  public static void setAllq(List sectors,double val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setq(sectorx,val); } }


  public void setL(double L_x) { L = L_x;  }

/*
  public static void setAllL(List sectors,int val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setL(sectorx,val); } }
*/

  public void setmu(double mu_x) { mu = mu_x;  }


  public static void setAllmu(List sectors,double val)
{ for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      Controller.inst().setmu(sectorx,val); } }


  public String getname() { return name; }

  public static List getAllname(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(sectorx.getname())) { }
      else { result.add(sectorx.getname()); } }
    return result; }

  public static List getAllOrderedname(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(sectorx.getname()); } 
    return result; }

  public int getn() { return n; }

  public static List getAlln(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(new Integer(sectorx.getn()))) { }
      else { result.add(new Integer(sectorx.getn())); } }
    return result; }

  public static List getAllOrderedn(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(new Integer(sectorx.getn())); } 
    return result; }

  public double getp() { return p; }

  public static List getAllp(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(new Double(sectorx.getp()))) { }
      else { result.add(new Double(sectorx.getp())); } }
    return result; }

  public static List getAllOrderedp(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(new Double(sectorx.getp())); } 
    return result; }

  public double getq() { return q; }

  public static List getAllq(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(new Double(sectorx.getq()))) { }
      else { result.add(new Double(sectorx.getq())); } }
    return result; }

  public static List getAllOrderedq(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(new Double(sectorx.getq())); } 
    return result; }

  public double getL() { return L; }

  public static List getAllL(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(new Double(sectorx.getL()))) { }
      else { result.add(new Double(sectorx.getL())); } }
    return result; }

  public static List getAllOrderedL(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(new Double(sectorx.getL())); } 
    return result; }

  public double getmu() { return mu; }

  public static List getAllmu(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      if (result.contains(new Double(sectorx.getmu()))) { }
      else { result.add(new Double(sectorx.getmu())); } }
    return result; }

  public static List getAllOrderedmu(List sectors)
  { List result = new Vector();
    for (int i = 0; i < sectors.size(); i++)
    { Sector sectorx = (Sector) sectors.get(i);
      result.add(new Double(sectorx.getmu())); } 
    return result; }

  
  //calculate the directdefault for this sector
  //used in P
    public double nocontagion(int m)
  {   double result = 0;
  Object cached_result = nocontagion_cache.get(new Integer(m));
  if (cached_result != null)
  { result = ((Double) cached_result).doubleValue(); 
    return result; 
  }
  else 
  {   result = Math.pow(( 1 - p ),n - m) * Math.pow(p,m) * Math.pow(( 1 - q ),m * ( n - m ));

    nocontagion_cache.put(new Integer(m), new Double(result));
  }
  return result;
 }

  //calculate the indirectdefault for this sector 
    //used in collect_0
    public double contagion(int i,int m)
  {   double result = 0;
 
  result = Math.pow(( 1 - p ),n - i) * Math.pow(p,i) * Math.pow(( 1 - q ),i * ( n - m )) * Math.pow(( 1 - Math.pow(( 1 - q ),i) ),m - i) * StatFunc.comb(m,i);
    return result;
  }


  private  java.util.Map nocontagion_cache = new java.util.HashMap();

}

//****************************************************************************************************************************
class Borrower
implements SystemTypes
{

private double p = 0; // internal
private int L = 0; // internal

public Borrower()
{
  this.p = 0;
  this.L = 0;
}

public void setp(double p_x) { p = p_x;  }

public double getp() { return p; }

public void setL(int L_x) { L = L_x;  }

public int getL() { return L; }

}


class BorrowerInSector
implements SystemTypes
{

private double theta = 0; // internal

private double omega = 0; // internal
private int sectorID = 0; // internal
private int borrowerID = 0; // internal

public BorrowerInSector()
{
  this.theta = 0; 
  this.omega = 0; // internal
  this.sectorID = 0; // internal
  this.borrowerID = 0; // internal
}

public void settheta(double theta_x) { theta = theta_x;  }

public void setomega(double omega_x) { omega = omega_x;  }

public void setsectorID(int ID_x) { sectorID = ID_x;  }

public void setborrowerID(int ID_x) { borrowerID = ID_x;  }


public double gettheta() { return theta; }

public double getomega() { return omega; }

public int getsectorID() { return sectorID; }

public int getborrowerID() { return borrowerID; }

}
//****************************************************************************************************************************

class StatFunc
  implements SystemTypes
{

  public StatFunc()
  {

  }



  public String toString()
  { String _res_ = "(StatFunc) ";
    return _res_;
  }

    public static int comb(int n,int m)
  {   int result = 0;
    if (n < m || m < 0) { return result; } 
    Object cached_result = comb_cache.get(n + ", " + m);
  if (cached_result != null)
  { result = ((Integer) cached_result).intValue(); 
    return result; 
  }
  else 
  {   if (n - m < m) 
  {   result = Set.prdint(Set.collect_3(Set.integerSubrange(m + 1,n))) / Set.prdint(Set.collect_4(Set.integerSubrange(1,n - m)));
 
  }  else   if (n - m >= m) 
  {   result = Set.prdint(Set.collect_3(Set.integerSubrange(n - m + 1,n))) / Set.prdint(Set.collect_4(Set.integerSubrange(1,m)));
 
  }
    comb_cache.put(n + ", " + m, new Integer(result));
  }
  return result;
 }


  private  static  java.util.Map comb_cache = new java.util.HashMap();

}





public class Controller implements SystemTypes, ControllerInterface
{
  Vector cdos = new Vector();
  Vector sectors = new Vector();
  Vector borrowers = new Vector();
  Vector borrowerinsectors = new Vector();
  Vector statfuncs = new Vector();
  private static Controller uniqueInstance; 


  private Controller() { } 


  public static Controller inst() 
    { if (uniqueInstance == null) 
    { uniqueInstance = new Controller(); }
    return uniqueInstance; } 


  public static void loadModel(String file)
  {
    try
    { BufferedReader br = null;
      File f = new File(file);
      try 
      { br = new BufferedReader(new FileReader(f)); }
      catch (Exception ex) 
      { System.err.println("No file: " + file); return; }
      Class cont = Class.forName("Controller");
      
      java.util.Map objectmap = new java.util.HashMap();
      
      while (true)
      { String line1;
        try { line1 = br.readLine(); }
        catch (Exception e)
        { return; }
        if (line1 == null)
        { return; }
        
        //remove spaces at begin and end
        line1 = line1.trim();

        if (line1.length() == 0) { continue; }
        
        String left;
        String op;
        String right;
        
        
        //end with an "  -->  sector name
        if (line1.charAt(line1.length() - 1) == '"')
        { int eqind = line1.indexOf("="); 
          if (eqind == -1) { continue; }
          else 
          { left = line1.substring(0,eqind-1).trim();
            op = "="; 
            right = line1.substring(eqind+1,line1.length()).trim();
          }
        }
        
        //other: cdo or npql
        else
        { 
          // break string into tokens by spaces
          StringTokenizer st1 = new StringTokenizer(line1);
          
          //val: parts of a line
          Vector vals1 = new Vector();
          while (st1.hasMoreTokens())
          { String val1 = st1.nextToken();
            vals1.add(val1);
          }
          
          //if a string has less than 3 parts --> jump
          if (vals1.size() < 3)
          { continue; }
          
          left = (String) vals1.get(0);
          op = (String) vals1.get(1);
          right = (String) vals1.get(2);
        }
        
        //if op is : 
        if (":".equals(op))
        { int i2 = right.indexOf(".");
        
          // if there is no . in the right side --> "c : CDO" or "s3 : Sector" or "b2 : BorrowerInSector" or "a1 : Borrower"
          if (i2 == -1)
          { Class cl;
          
            //get the class
            try { cl = Class.forName("" + right); }
            catch (Exception _x) { System.err.println("No entity: " + right); continue; }
            
            //new an instance
            Object xinst = cl.newInstance();
            
            //push the object into the objectmap (name,object) --> (c,CDO) 
            objectmap.put(left,xinst);
            
            
            Class[] cargs = new Class[] { cl };
            
            //controller get a method with --> addCDO or addSector or addBorrower or addBorrowerInSector
            Method addC = cont.getMethod("add" + right,cargs);
            if (addC == null) { continue; }
            
            //invoke the method found in Class controller and add this object
            Object[] args = new Object[] { xinst };
            addC.invoke(Controller.inst(),args);
          }
          
          //if there is a . in the right side --> "s1 : c.sectors" or "b2 : s1.borrowers"
          else
          { 
        	//***********************************************************************
        	  
        	//add sector s1 in cdo c, this is alright 
     
        	    //and for the b2, I need to assign the sectorID for it
        	  		
        	  		//but sector s1 need to know the name of its cdo 
        	  
        	
            String role = right.substring(i2+1,right.length());//role: sectors
            
            
        	String obj = right.substring(0,i2);// obj: c
            Object objinst = objectmap.get(obj); //objinst: get the instance c
                  
            if (objinst == null) 
            { continue; }
            
            Object val = objectmap.get(left);//val: get the instance s1
            if (val == null) 
            { continue; }
            Class objC = objinst.getClass();
            Class typeclass = val.getClass(); 
            Object[] args = new Object[] { val }; 
            Class[] settypes = new Class[] { typeclass };
            
            //get a method called cdo.addsectors
            Method addrole = Controller.findMethod(objC,"add" + role);
            if (addrole != null) 
            { 
            	//c.addsectors(s1)
            	addrole.invoke(objinst, args); 
            }
            else { System.err.println("Error: cannot add to " + role); }
             
          }
            
            
          
          
        }
        
        
        //n,p,q,l,name --> "s7.p = 0.017" this is alright 
        	//"b1.borrower = a1" --> but I need to assign borrowerID for b1
        else if ("=".equals(op))
        { 
          int i1 = left.indexOf(".");
          if (i1 == -1) 
          { continue; }
          
          //there should be a . in the left side
          String obj = left.substring(0,i1);//obj : s7
          String att = left.substring(i1+1,left.length());//att: p
          Object objinst = objectmap.get(obj); //objinst: get the instance s7
          if (objinst == null) 
          { continue; }
          
          Class objC = objinst.getClass();//objC : Sector
          Class typeclass; 
          Object val; 
          
          // set the sector name
          if (right.charAt(0) == '"' &&
              right.charAt(right.length() - 1) == '"')
          { 
        	typeclass = String.class;//typeclass: String
            val = right.substring(1,right.length() - 1);//val : the name
          } 
          
          //???????????????????????????????????
          else if ("true".equals(right) || "false".equals(right))
          { typeclass = boolean.class;
            if ("true".equals(right))
            { val = new Boolean(true); }
            else
            { val = new Boolean(false); }
          }
          
          //n,q,p,l
          else 
          { val = objectmap.get(right);
            if (val != null)
            { typeclass = val.getClass(); }
            else 
            { int i;
              long l; 
              double d;
              try 
              { i = Integer.parseInt(right);
                typeclass = int.class;
                val = new Integer(i); 
              }
              catch (Exception ee)
              { try 
                { l = Long.parseLong(right);
                  typeclass = long.class;
                  val = new Long(l); 
                }
                catch (Exception eee)
                { try
                  { d = Double.parseDouble(right);
                    typeclass = double.class;
                    val = new Double(d);
                  }
                  catch (Exception ff)
                  { continue; }
                }
              }
            }
          }
          
          Object[] args = new Object[] { val }; 
          Class[] settypes = new Class[] { typeclass };
          
          //get the method s7.setp or s7.setn or ....
          Method setatt = Controller.findMethod(objC,"set" + att);
          
          if (setatt != null) 
          { 
        	//invoke (Sector) s7.setp(val)
            setatt.invoke(objinst, args); 
          }
          else { System.err.println("No attribute: " + att); }
          
        //**************************************************************************
        }
      }
    } catch (Exception e) { }
  }

  
  
  public static Method findMethod(Class c, String name)
  { 
	Method[] mets = c.getMethods(); 
    for (int i = 0; i < mets.length; i++)
    { Method m = mets[i];
      if (m.getName().equals(name))
      { return m; }
    } 
    return null;
  }


  public void checkCompleteness() {   }


  public void saveModel(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
  for (int _i = 0; _i < cdos.size(); _i++)
  { CDO cdox_ = (CDO) cdos.get(_i);
    out.println("cdox_" + _i + " : CDO");
    out.println("cdox_" + _i + ".ps0 = " + cdox_.getps0());
  }

  for (int _i = 0; _i < sectors.size(); _i++)
  { Sector sectorx_ = (Sector) sectors.get(_i);
    out.println("sectorx_" + _i + " : Sector");
    out.println("sectorx_" + _i + ".name = \"" + sectorx_.getname() + "\"");
    out.println("sectorx_" + _i + ".n = " + sectorx_.getn());
    out.println("sectorx_" + _i + ".p = " + sectorx_.getp());
    out.println("sectorx_" + _i + ".q = " + sectorx_.getq());
    out.println("sectorx_" + _i + ".L = " + sectorx_.getL());
    out.println("sectorx_" + _i + ".mu = " + sectorx_.getmu());
  }

  for (int _i = 0; _i < statfuncs.size(); _i++)
  { StatFunc statfuncx_ = (StatFunc) statfuncs.get(_i);
    out.println("statfuncx_" + _i + " : StatFunc");
  }

  for (int _i = 0; _i < cdos.size(); _i++)
  { CDO cdox_ = (CDO) cdos.get(_i);
    List cdo_sectors_Sector = cdox_.getsectors();
    for (int _j = 0; _j < cdo_sectors_Sector.size(); _j++)
    { out.println("sectorx_" + sectors.indexOf(cdo_sectors_Sector.get(_j)) + " : cdox_" + _i + ".sectors");
    }
  }
    out.close(); 
  }


  public void saveXSI(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<My:model xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\">");
    for (int _i = 0; _i < cdos.size(); _i++)
    { CDO cdox_ = (CDO) cdos.get(_i);
       out.print("<cdos xsi:type=\"My:CDO\"");
    out.print(" ps0=\"" + cdox_.getps0() + "\" ");
    out.print(" sectors = \"");
    List cdo_sectors = cdox_.getsectors();
    for (int _j = 0; _j < cdo_sectors.size(); _j++)
    { out.print(" //@sectors." + sectors.indexOf(cdo_sectors.get(_j)));
    }
    out.print("\"");
    out.println(" />");
  }

    for (int _i = 0; _i < sectors.size(); _i++)
    { Sector sectorx_ = (Sector) sectors.get(_i);
       out.print("<sectors xsi:type=\"My:Sector\"");
    out.print(" name=\"" + sectorx_.getname() + "\" ");
    out.print(" n=\"" + sectorx_.getn() + "\" ");
    out.print(" p=\"" + sectorx_.getp() + "\" ");
    out.print(" q=\"" + sectorx_.getq() + "\" ");
    out.print(" L=\"" + sectorx_.getL() + "\" ");
    out.print(" mu=\"" + sectorx_.getmu() + "\" ");
    out.println(" />");
  }

    for (int _i = 0; _i < statfuncs.size(); _i++)
    { StatFunc statfuncx_ = (StatFunc) statfuncs.get(_i);
       out.print("<statfuncs xsi:type=\"My:StatFunc\"");
    out.println(" />");
  }

    out.println("</My:model>");
    out.close(); 
  }



  public void addCDO(CDO oo) { cdos.add(oo); }

  public void addSector(Sector oo) { sectors.add(oo); }

  public void addStatFunc(StatFunc oo) { statfuncs.add(oo); }
  
  
//*********************  
  public void addBorrower(Borrower oo) { borrowers.add(oo); }
  
  public void addBorrowerInSector(BorrowerInSector oo) { borrowerinsectors.add(oo); }
//********************


  public void createAllCDO(List cdox)
  { for (int i = 0; i < cdox.size(); i++)
    { CDO cdox_x = (CDO) cdox.get(i);
      if (cdox_x == null) { cdox_x = new CDO(); }
      cdox.set(i,cdox_x);
      addCDO(cdox_x);
    }
  }


  public CDO createCDO()
  { 
    CDO cdox = new CDO();
    addCDO(cdox);
    setps0(cdox,0);
    setsectors(cdox,new Vector());

    return cdox;
  }

  public void createAllSector(List sectorx)
  { for (int i = 0; i < sectorx.size(); i++)
    { Sector sectorx_x = (Sector) sectorx.get(i);
      if (sectorx_x == null) { sectorx_x = new Sector(); }
      sectorx.set(i,sectorx_x);
      addSector(sectorx_x);
    }
  }


  public Sector createSector()
  { 
    Sector sectorx = new Sector();
    addSector(sectorx);
    setname(sectorx,"");
    setn(sectorx,0);
    //setp(sectorx,0);
    setq(sectorx,0);
    //setL(sectorx,0);
    setmu(sectorx,0);

    return sectorx;
  }

  public void createAllStatFunc(List statfuncx)
  { for (int i = 0; i < statfuncx.size(); i++)
    { StatFunc statfuncx_x = (StatFunc) statfuncx.get(i);
      if (statfuncx_x == null) { statfuncx_x = new StatFunc(); }
      statfuncx.set(i,statfuncx_x);
      addStatFunc(statfuncx_x);
    }
  }


  public StatFunc createStatFunc()
  { 
    StatFunc statfuncx = new StatFunc();
    addStatFunc(statfuncx);

    return statfuncx;
  }

  
  
  //public void createAllBorrower()
  //public void createAllBorrowerInSector()
  //public Borrower createBorrower()
  //public BorrowerInSector createBorrowerInSector()

  
  
public void setps0(CDO cdox, double ps0_x) 
  { cdox.setps0(ps0_x);
    }

//************************************
public void setpforSectors(CDO cdox) 
  {  cdox.setpforSectors();
	}

public void setLforSectors(CDO cdox) 
  {  cdox.setLforSectors();
	}

public void setvariance(CDO cdox) 
  {  cdox.setvariance();
	}
//**************************************

  public void setsectors(CDO cdox, List sectorsxx) 
  {   List _oldsectorsxx = cdox.getsectors();
  for (int _i = 0; _i < sectorsxx.size(); _i++)
  { Sector _xx = (Sector) sectorsxx.get(_i);
    if (_oldsectorsxx.contains(_xx)) { }
    else { CDO.removeAllsectors(cdos, _xx); }
  }
    cdox.setsectors(sectorsxx);
      }


  public void setsectors(CDO cdox, int _ind, Sector sectorx) 
  { cdox.setsectors(_ind,sectorx); }
  
  public void addsectors(CDO cdox, Sector sectorsxx) 
  {   CDO.removeAllsectors(cdos,sectorsxx);
    cdox.addsectors(sectorsxx);
    }


  public void removesectors(CDO cdox, Sector sectorsxx) 
  { cdox.removesectors(sectorsxx);
    }


 public void unionsectors(CDO cdox,List sectorsx)
  { for (int _i = 0; _i < sectorsx.size(); _i++)
    { Sector sectorxsectors = (Sector) sectorsx.get(_i);
      addsectors(cdox,sectorxsectors);
     } } 


 public void subtractsectors(CDO cdox,List sectorsx)
  { for (int _i = 0; _i < sectorsx.size(); _i++)
    { Sector sectorxsectors = (Sector) sectorsx.get(_i);
      removesectors(cdox,sectorxsectors);
     } } 


public void setname(Sector sectorx, String name_x) 
  { sectorx.setname(name_x);
    }


public void setn(Sector sectorx, int n_x) 
  { sectorx.setn(n_x);
    }

//***************************************************************************************
public void setp(Borrower borrowerx, double p_x) 
  { borrowerx.setp(p_x);
    }


public void setq(Sector sectorx, double q_x) 
  { sectorx.setq(q_x);
    }


public void setL(Borrower borrowerx, int L_x) 
  { borrowerx.setL(L_x);
    }

public void setomega(BorrowerInSector borrowerinsectorx, double omega_x) 
{ borrowerinsectorx.setomega(omega_x);
  }

public void settheta(BorrowerInSector borrowerinsectorx, double theta_x) 
{ borrowerinsectorx.settheta(theta_x);
  }

public void setborrowerID(BorrowerInSector borrowerinsectorx, int id_x) 
{ borrowerinsectorx.setborrowerID(id_x);
  }

public void setsectorID(BorrowerInSector borrowerinsectorx, int id_x) 
{ borrowerinsectorx.setsectorID(id_x);
  }

//***************************************************************************************

public void setmu(Sector sectorx, double mu_x) 
  { sectorx.setmu(mu_x);
    }



  public  List AllCDOnocontagion(List cdoxs,int k,int m)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Double(cdox.nocontagion(k, m)));
    }
    return result; 
  }

  public  List AllCDOP(List cdoxs,int k,int m)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Double(cdox.P(k, m)));
    }
    return result; 
  }

  public  List AllCDOPCond(List cdoxs,int k,int m)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Double(cdox.PCond(k, m)));
    }
    return result; 
  }

  public  List AllCDOmaxfails(List cdoxs,int k,int s)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Integer(cdox.maxfails(k, s)));
    }
    return result; 
  }

  public  List AllCDOPS(List cdoxs,int s)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Double(cdox.PS(s)));
    }
    return result; 
  }

  public  List AllCDOVS(List cdoxs,int k,int s)
  { 
    List result = new Vector();
    for (int _i = 0; _i < cdoxs.size(); _i++)
    { CDO cdox = (CDO) cdoxs.get(_i);
      result.add(new Double(cdox.VS(k, s)));
    }
    return result; 
  }

  public void test1(CDO cdox,Sector s)
  {   cdox.test1(s);
   }

  public void test1outer(CDO cdox)
  {   cdox.test1outer();
   }

  public void test2(CDO cdox)
  {   cdox.test2();
   }

  public void test3(CDO cdox)
  {   cdox.test3();
   }

  public  List AllSectornocontagion(List sectorxs,int m)
  { 
    List result = new Vector();
    for (int _i = 0; _i < sectorxs.size(); _i++)
    { Sector sectorx = (Sector) sectorxs.get(_i);
      result.add(new Double(sectorx.nocontagion(m)));
    }
    return result; 
  }

  public  List AllSectorcontagion(List sectorxs,int i,int m)
  { 
    List result = new Vector();
    for (int _i = 0; _i < sectorxs.size(); _i++)
    { Sector sectorx = (Sector) sectorxs.get(_i);
      result.add(new Double(sectorx.contagion(i, m)));
    }
    return result; 
  }

 public static int comb(int n,int m)
 { return StatFunc.comb(n, m); }



  public void killAllCDO(List cdoxx)
  { for (int _i = 0; _i < cdoxx.size(); _i++)
    { killCDO((CDO) cdoxx.get(_i)); }
  }

  public void killCDO(CDO cdoxx)
  { cdos.remove(cdoxx);
  }



  public void killAllSector(List sectorxx)
  { for (int _i = 0; _i < sectorxx.size(); _i++)
    { killSector((Sector) sectorxx.get(_i)); }
  }

  public void killSector(Sector sectorxx)
  { sectors.remove(sectorxx);
    Vector _1qrangesectorsCDO = new Vector();
    _1qrangesectorsCDO.addAll(cdos);
    for (int _i = 0; _i < _1qrangesectorsCDO.size(); _i++)
    { CDO cdox = (CDO) _1qrangesectorsCDO.get(_i);
      if (cdox.getsectors().contains(sectorxx))
      { removesectors(cdox,sectorxx); }
    }
  }



  public void killAllStatFunc(List statfuncxx)
  { for (int _i = 0; _i < statfuncxx.size(); _i++)
    { killStatFunc((StatFunc) statfuncxx.get(_i)); }
  }

  public void killStatFunc(StatFunc statfuncxx)
  { statfuncs.remove(statfuncxx);
  }




  
    public void test() 
  {    Date d1 = new Date();
       long t1 = d1.getTime(); 


       List cdotest1outerx = new Vector();
  cdotest1outerx.addAll(Controller.inst().cdos);
  for (int cdotest1outerx_ind4 = 0; cdotest1outerx_ind4 < cdotest1outerx.size(); cdotest1outerx_ind4++)
  { Controller.inst().test1outer((CDO) cdotest1outerx.get(cdotest1outerx_ind4)); }

       List cdotest2x = new Vector();
  cdotest2x.addAll(Controller.inst().cdos);
  for (int cdotest2x_ind5 = 0; cdotest2x_ind5 < cdotest2x.size(); cdotest2x_ind5++)
  { Controller.inst().test2((CDO) cdotest2x.get(cdotest2x_ind5)); }

       List cdotest3x = new Vector();
  cdotest3x.addAll(Controller.inst().cdos);
  for (int cdotest3x_ind6 = 0; cdotest3x_ind6 < cdotest3x.size(); cdotest3x_ind6++)
  { Controller.inst().test3((CDO) cdotest3x.get(cdotest3x_ind6)); }

   Date d2 = new Date();
   long t2 = d2.getTime(); 
   System.out.println("Time = " + (t2-t1)); 

  }


 
}



