package br.com.comprecerto.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.entities.Faq;
import br.com.comprecerto.api.services.FaqService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/faqs")
public class FaqController {

	@Autowired
	private FaqService faqService;

	@GetMapping
	public ResponseEntity<List<Faq>> buscarFaqs() {
		return ResponseEntity.ok(faqService.buscarFaqs());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Faq> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(faqService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Faq> salvarFaq(@RequestBody @Valid Faq faq) {
		return ResponseEntity.ok(faqService.salvarFaq(faq));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarFaq(@PathVariable Integer id, @RequestBody @Valid Faq faq) {
		try {
			return ResponseEntity.ok(faqService.atualizarFaq(id, faq));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarFaq(@PathVariable Integer id) {
		try {
			faqService.deletarFaq(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
