package pojos.DeanContactGetAllPojos;

import java.io.Serializable;

public class ContactPageablePojo implements Serializable {
	private ContactSortPojo sort;
	private int offset;
	private int pageNumber;
	private int pageSize;
	private boolean paged;
	private boolean unpaged;

	public ContactPageablePojo() {
	}

	public ContactPageablePojo(ContactSortPojo sort, int offset, int pageNumber, int pageSize, boolean paged, boolean unpaged) {
		this.sort = sort;
		this.offset = offset;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.paged = paged;
		this.unpaged = unpaged;
	}

	public void setSort(ContactSortPojo sort){
		this.sort = sort;
	}

	public ContactSortPojo getSort(){
		return sort;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setPageNumber(int pageNumber){
		this.pageNumber = pageNumber;
	}

	public int getPageNumber(){
		return pageNumber;
	}

	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}

	public int getPageSize(){
		return pageSize;
	}

	public void setPaged(boolean paged){
		this.paged = paged;
	}

	public boolean isPaged(){
		return paged;
	}

	public void setUnpaged(boolean unpaged){
		this.unpaged = unpaged;
	}

	public boolean isUnpaged(){
		return unpaged;
	}

	@Override
 	public String toString(){
		return 
			"PageablePojo{" + 
			"sort = '" + sort + '\'' + 
			",offset = '" + offset + '\'' + 
			",pageNumber = '" + pageNumber + '\'' + 
			",pageSize = '" + pageSize + '\'' + 
			",paged = '" + paged + '\'' + 
			",unpaged = '" + unpaged + '\'' + 
			"}";
		}
}