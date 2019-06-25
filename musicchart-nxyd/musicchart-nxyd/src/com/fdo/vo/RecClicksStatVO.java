package com.fdo.vo;

/**  
* @Title: RecClicksStatVO.java  
* @Package com.fdo.vo  
* @Description: 推荐位点击量统计
* @author aliuyanbo  
* @date 2018年4月8日 
*/
public class RecClicksStatVO {

	private Integer id;
	/**  
	* @Fields field:{推荐位名称}
	*/
	private String recName;
	/**  
	* @Fields field:{总点击数}
	*/
	private Integer clicks;
	/**  
	* @Fields field:{用户点击数（去重）}
	*/
	private Integer userClicks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Integer getUserClicks() {
		return userClicks;
	}

	public void setUserClicks(Integer userClicks) {
		this.userClicks = userClicks;
	}

	@Override
	public String toString() {
		return "RecClicksStatVO [id=" + id + ", recName=" + recName + ", clicks=" + clicks + ", userClicks="
				+ userClicks + "]";
	}

}
