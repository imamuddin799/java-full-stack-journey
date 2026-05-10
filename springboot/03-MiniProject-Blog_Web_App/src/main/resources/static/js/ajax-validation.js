$(function() {
	let debounceTimer;
	function debounce(fn, delay = 400) {
		clearTimeout(debounceTimer);
		debounceTimer = setTimeout(fn, delay);
	}

	function validateField(selector, url, errorSelector, blogId = null) {
		const value = $(selector).val().trim();
		const params = { [$(selector).attr('id')]: value };
		if (blogId) {
			params.blogId = blogId;
		}
		if (!value) return;
		$.get(url, params, function(isUnique) {
			if (!isUnique) {
				$(errorSelector).removeClass('d-none');
			} else {
				$(errorSelector).addClass('d-none');
			}
		});
	}

	$('#title').on('input blur', function() {
		const blogId = $("#blogId").text().trim();
		debounce(() => validateField('#title', '/blogs/validate/title', '#titleError', blogId));
	});

	$('#addBlogForm, #editBlogForm').on('submit', function(e) {
		if (!$('#titleError').hasClass('d-none')) {
			e.preventDefault();
			alert('Please fix duplicate fields before submitting.');
		}
	});
});