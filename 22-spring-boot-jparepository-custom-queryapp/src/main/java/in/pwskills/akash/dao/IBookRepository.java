package in.pwskills.akash.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
	//R.T findByVariableNameCondition(params)
	
	//select * from booktab where bauth=?
	List<Book>findByAuthor(String authorName);
	
	//select * from booktab where bcost>=?
	List<Book> findByBookCostGreaterThanEqual(Integer price);
	
	//select * from booktab where bid IN (?,?)
	List<Book> findByBookIdIn(List<Integer>ids);
	
	//select * from booktab where bid between x and y
	List<Book> findByBookIdBetween(Integer x, Integer y);
	
	//select * from booktab where bid <= ? or bType like ?
	List<Book> findByBookIdLessThanEqualOrBookTypeLike(Integer bid,String bookType);
	
	//select * from booktab where bookcost != ? and author not like ?
	List<Book> findByBookCostNotAndAuthorNotLike(Double cost,String author);
	
	//select * from booktab where bauth IS NULL;
	List<Book> findByAuthorIsNull();
	
	//select * from booktab where bauth IS Not NULL;
	List<Book> findByAuthorIsNotNull();
	
	//select * from booktab where bid=?
	Optional<Book> findByBookId(Integer id);
	
}
