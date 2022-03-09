<script>
  import Textfield from "@smui/textfield";
  import Button from "@smui/button";
  import SnackbarComponentDev from "@smui/snackbar";
  import Snackbar, { Actions, Label } from "@smui/snackbar";
  let snackbar = SnackbarComponentDev;
  let input = "";
  let output = "";
  let disabled = true;
  $: if (output) disabled = false;
  else disabled = true;
  function debounce(callback, delay) {
    var timeout;
    return function () {
      var args = arguments;
      clearTimeout(timeout);
      timeout = setTimeout(
        function () {
          callback.apply(this, args);
        }.bind(this),
        delay
      );
    };
  }

  async function encode() {
    if (input) {
      const response = await fetch(`http://localhost:8888/api/encode/${input}`);
      const text = await response.text();
      output = text;
    } else output = "";
  }
  const handle = debounce(() => {
    encode();
  }, 500);
</script>

<main>
  <Textfield
    textarea
    input$rows={15}
    input$cols={35}
    input$resizable={false}
    label="Input"
    bind:value={input}
    on:input={handle}
  />
  <Textfield
    textarea
    disabled
    input$rows={15}
    input$cols={35}
    input$resizable={false}
    label="Output"
    bind:value={output}
  />
  <br />
  <Button
    {disabled}
    variant="raised"
    on:click={() => {
      disabled = true;
      navigator.clipboard.writeText(output);
      snackbar.open();
    }}>copy output</Button
  >
  <Snackbar bind:this={snackbar}>
    <Label>Copied successfully.</Label>
  </Snackbar>
</main>

<style>
  main {
    text-align: center;
    padding: 1em;
    max-width: 240px;
    margin: 0 auto;
  }

  h1 {
    color: #ff3e00;
    text-transform: uppercase;
    font-size: 4em;
    font-weight: 100;
  }

  @media (min-width: 640px) {
    main {
      max-width: none;
    }
  }
</style>
