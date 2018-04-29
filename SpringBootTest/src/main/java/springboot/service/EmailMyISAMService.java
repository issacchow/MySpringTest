package springboot.service;

import springboot.dto.EmailDto;
import springboot.data.PagingRequest;
import springboot.data.PagingResult;

public interface EmailMyISAMService {

    PagingResult<EmailDto> selectByPaging(PagingRequest request);

    void generateEmails(int count);
}
