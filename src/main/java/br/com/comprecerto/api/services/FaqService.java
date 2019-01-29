package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Faq;
import br.com.comprecerto.api.repositories.FaqRepository;

@Service
public class FaqService {

	@Autowired
	private FaqRepository faqRepository;

	public List<Faq> buscarFaqs() {
		return faqRepository.findAll();
	}

	public Faq buscarPorId(Integer id) {
		Optional<Faq> faq = faqRepository.findByIdFaq(id);

		if (faq.isPresent())
			return faq.get();

		return null;
	}

	public Faq salvarFaq(@Valid Faq faq) {
		return faqRepository.saveAndFlush(faq);
	}

	public Faq atualizarFaq(Integer id, @Valid Faq faq) throws Exception {
		Optional<Faq> faqOp = faqRepository.findByIdFaq(id);

		if (!faqOp.isPresent())
			throw new Exception("A Faq informada não existe!");

		return salvarFaq(faq);
	}

	public void deletarFaq(Integer id) throws Exception {
		Optional<Faq> faqOp = faqRepository.findByIdFaq(id);

		if (!faqOp.isPresent())
			throw new Exception("A Faq informada não existe!");

		faqRepository.delete(faqOp.get());
	}

}
