import { Card, CardBody, CardFooter, flexbox } from '@chakra-ui/react';
import { Image, Stack, Button, ButtonGroup, Divider, Text } from '@chakra-ui/react';
import { Progress } from '@chakra-ui/react';

export default function Project() {
    return (    
      <Card maxW='sm' borderWidth='3px' borderColor='#CC6FED' margin='20px'>
        <CardBody>
          <Image
            src='https://i.pinimg.com/originals/61/cc/b4/61ccb4842c843263bfbb13e3b77bfdab.jpg'
            alt='Imagem do Projeto'
            borderRadius='lg'
          />
          <Stack mt='6' spacing='6'>
            <Text fontSize='2xl'><strong>{'Nome do Projeto'}</strong></Text>
            <Text fontSize='sm'>{'Autor'}</Text>
            <Text>
              {'This sofa is perfect for modern tropical spaces, baroque inspired spaces, earthy toned spaces and for people who love a chic design with a sprinkle of vintage design.'}
            </Text>
            <Progress colorScheme='purple' size='sm' value={20} />
            <Text style={{
              display: 'flex', 
              justifyContent: 'space-between' }}>
                <strong>{'20%'}</strong><span ><strong>{'R$20.00,00'}</strong></span></Text>
          </Stack>
        </CardBody>
        <Divider />
        <CardFooter>
          <ButtonGroup spacing='2'>
            <Button fontSize='14px' variant='solid' colorScheme='purple'>
              Apoiar
            </Button>
          </ButtonGroup>
        </CardFooter>
      </Card>
    );
}