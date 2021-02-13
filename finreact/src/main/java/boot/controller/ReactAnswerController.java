package boot.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import boot.dao.MysqlAnswerMapper;
import boot.dto.AnswerDto;

@CrossOrigin
@RestController
public class ReactAnswerController {

	@Autowired
	MysqlAnswerMapper mapper;

	@PostMapping("/answer/insert")
	public Map<String, String> insert(
			@RequestBody AnswerDto dto) {
	
		//db에 인서트
		mapper.insertAnswer(dto);
		
		//리턴 할 메세지
		Map<String, String> map=new HashMap<String, String>();
		map.put("mes","Insert Success");
		return map;
	}
}
