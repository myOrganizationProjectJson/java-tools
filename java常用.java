///分行读取文件


ins = new FileInputStream(xml);
bfRead = new BufferedReader(new InputStreamReader(ins));

	String tmpStr = bfRead.readLine();
			int lineNumber = 0;
			while (null != tmpStr) {
				//将读取的文件转为xml格式取值
				doc = DocumentHelper.parseText(tmpStr);
				Element itemEle = doc.getRootElement();
				String dataType = itemEle.attributeValue("dataType");
				
				
			    
				
		    	tmpStr = bfRead.readLine();
			}
			
////////list用法///////

List<BetDetailModel> betDetailList = new ArrayList<BetDetailModel>();
betDetailModel = new BetDetailModel();
betDetailModel.setDataType(itemEle.attributeValue("dataType"));
betDetailList.add(betDetailModel);

///遍历
for (BetDetailModel betInfo : betDetailList) {

betInfo.getDataType();

}
////////////////////////////////////////////////////////////////////
/////Map的用法////////////////////

 Map<String, Integer> lineNumberMap = new HashMap<String, Integer>();
 lineNumberMap.put(xml, lineNumber);
 lineNumberMap.get(xml);
 
 
 /////////////////////////////常用数据查询遍历///////////////////////
       String sql = "select id,begin_time beginTime,end_time endTime,status status,create_time createTime from rfcorp_supplement where game_platform = '"+platForm+"' and status = 0 limit 5" ;
		ResultSet rs = null;
      	rs = connection.createStatement().executeQuery(sql);
		List<SupplementModel> supplementList = new ArrayList<SupplementModel>();
		
		while(rs.next()){
			SupplementModel supplement = new SupplementModel();
			supplement.setId(rs.getInt("id"));
			supplement.setBeginTime(rs.getString("beginTime"));
			supplement.setEndTime(rs.getString("endTime"));
			supplement.setCreateTime(rs.getInt("createTime"));
			supplement.setStatus(rs.getInt("status"));
			
			supplementList.add(supplement);
		}
 
 
 	    rs.close();
		connection.close();
 
 
 /////for遍历//////
 List<SupplementModel> supplementList = null;
 

 	for (SupplementModel item : supplementList) {
		System.out.println("----------------补单数据------------" + item.getStatus() + "--" + item.getCreateTime()
				+ "--" + item.getId());
		logger.info("=============补单数据ID============================================="+item.getId());
		if(item.isFlg()) {
			item.setFlg(false);
			if (createRecordByTime(item.getBeginTime(), item.getEndTime())) {
				item.setFlg(true);
			}
		}
				

	}
 
 ///////////////////////////////SQL组装////////////////////////
 
		Connection connection = ConnectionManager.getConnection();

		String sql = "insert into rfcorp_supplement values (0, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, supplement.getBeginTime());
		preparedStatement.setString(2, supplement.getEndTime());
		preparedStatement.setLong(3, supplement.getCreateTime());
		preparedStatement.setInt(4, supplement.getStatus());
		preparedStatement.setString(5, supplement.getGamePlatform());
	    int result = preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
		
		
	/////////////////////////////list循环用法////////////////////
		info infos = null;
		infos=new info();
		infos.setPlayerId("1100");
		infos.setTotal_PNL("testss");
		infos.setTotal_Stake_Accurate("gggggg");
		
		List<info> lists= new ArrayList<info>();
		lists.add(infos);
		for(info z:lists){
			System.out.println(z.getPlayerId());
		}
		
		Iterator<info> iter = lists.iterator();
		  
		 while(iter.hasNext())  
	        {  
	           System.out.println(iter.next().getPlayerId());  
	        }  
		  Map map = new HashMap();
		  
		  map.put("aaa","aaa");
		  
	    	System.out.println(map.get("aaa"));
			
 
 
 
 