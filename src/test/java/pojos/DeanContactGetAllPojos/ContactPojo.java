package pojos.DeanContactGetAllPojos;

import java.util.List;
import java.io.Serializable;

public class ContactPojo implements Serializable {
	private List<ContactContentPojo> content;
	private ContactPageablePojo pageable;
	private int totalPages;
	private int totalElements;
	private boolean last;
	private int number;
	private ContactSortPojo sort;
	private int size;
	private int numberOfElements;
	private boolean first;
	private boolean empty;

	public ContactPojo() {
	}

	public ContactPojo(List<ContactContentPojo> content, ContactPageablePojo pageable, int totalPages, int totalElements, boolean last, int number, ContactSortPojo sort, int size, int numberOfElements, boolean first, boolean empty) {
		this.content = content;
		this.pageable = pageable;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.last = last;
		this.number = number;
		this.sort = sort;
		this.size = size;
		this.numberOfElements = numberOfElements;
		this.first = first;
		this.empty = empty;
	}

	public void setContent(List<ContactContentPojo> content){
		this.content = content;
	}

	public List<ContactContentPojo> getContent(){
		return content;
	}

	public void setPageable(ContactPageablePojo pageable){
		this.pageable = pageable;
	}

	public ContactPageablePojo getPageable(){
		return pageable;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setTotalElements(int totalElements){
		this.totalElements = totalElements;
	}

	public int getTotalElements(){
		return totalElements;
	}

	public void setLast(boolean last){
		this.last = last;
	}

	public boolean isLast(){
		return last;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setSort(ContactSortPojo sort){
		this.sort = sort;
	}

	public ContactSortPojo getSort(){
		return sort;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setNumberOfElements(int numberOfElements){
		this.numberOfElements = numberOfElements;
	}

	public int getNumberOfElements(){
		return numberOfElements;
	}

	public void setFirst(boolean first){
		this.first = first;
	}

	public boolean isFirst(){
		return first;
	}

	public void setEmpty(boolean empty){
		this.empty = empty;
	}

	public boolean isEmpty(){
		return empty;
	}

	@Override
 	public String toString(){
		return 
			"ContactPojo{" + 
			"content = '" + content + '\'' + 
			",pageable = '" + pageable + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",totalElements = '" + totalElements + '\'' + 
			",last = '" + last + '\'' + 
			",number = '" + number + '\'' + 
			",sort = '" + sort + '\'' + 
			",size = '" + size + '\'' + 
			",numberOfElements = '" + numberOfElements + '\'' + 
			",first = '" + first + '\'' + 
			",empty = '" + empty + '\'' + 
			"}";
		}
}